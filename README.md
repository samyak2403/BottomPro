# BottomBarPro

A stylish custom bottom navigation bar for Android with a prominent center action button and beautiful animations.

![BottomBarPro](https://github.com/samyak2403/BottomPro/blob/master/images/1.png)

## Features

- Modern, rounded black navigation bar
- Prominent blue circular add button in the center
- Clean white icons for better visibility
- Built-in animations for better user experience
- Simple implementation with customizable icons
- Easy-to-use click listeners

## Installation

### Step 1: Add the library to your project

Add the library to your project by including it in your `settings.gradle.kts` file:

```kotlin
include(":bottombarpro")
```

Then add the dependency to your app's `build.gradle.kts` file:

```kotlin
dependencies {
    implementation ("com.github.samyak2403:BottomPro:Tag")
}
```

## Usage

### Step 1: Add BottomBarPro to your layout

```xml
<androidx.constraintlayout.widget.ConstraintLayout 
    xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent">

    <!-- Your content here -->
    <FrameLayout
        android:id="@+id/fragment_container"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        app:layout_constraintBottom_toTopOf="@+id/bottom_bar_pro"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <!-- BottomBarPro implementation -->
    <com.samyak2403.bottombarpro.BottomBarPro
        android:id="@+id/bottom_bar_pro"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

### Step 2: Implement the listener in your Activity

```kotlin
class MainActivity : AppCompatActivity(), BottomBarPro.OnNavigationItemClickListener {
    
    private lateinit var bottomBarPro: BottomBarPro
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Initialize BottomBarPro
        bottomBarPro = findViewById(R.id.bottom_bar_pro)
        
        // Set click listener
        bottomBarPro.setOnNavigationItemClickListener(this)
    }
    
    // Implement the required methods from the interface
    override fun onHomeClick() {
        // Handle home click
        Toast.makeText(this, "Home selected", Toast.LENGTH_SHORT).show()
    }
    
    override fun onPersonClick() {
        // Handle person click
        Toast.makeText(this, "Profile selected", Toast.LENGTH_SHORT).show()
    }
    
    override fun onAddClick() {
        // Handle add click
        Toast.makeText(this, "Add selected", Toast.LENGTH_SHORT).show()
    }
    
    override fun onBriefcaseClick() {
        // Handle briefcase click
        Toast.makeText(this, "Briefcase selected", Toast.LENGTH_SHORT).show()
    }
    
    override fun onSendClick() {
        // Handle send click
        Toast.makeText(this, "Send selected", Toast.LENGTH_SHORT).show()
    }
}
```

## Animations

BottomBarPro comes with built-in animations that enhance the user experience:

### Default Animations

- **Selection Animation**: When a navigation item is selected, it scales up while the previously selected item scales down
- **Add Button Animation**: The center add button has a special bounce animation when clicked

### Using Programmatic Selection

You can programmatically select an item with animation:

```kotlin
// Select the person icon programmatically
bottomBarPro.selectItem(R.id.nav_person)
```

### Adding Custom Animations

You can apply additional animations to any navigation item:

```kotlin
// Apply rotation animation to the add button
bottomBarPro.applyRotationAnimation(R.id.nav_add)

// Apply a custom animation to the send button
val customAnim = AnimationUtils.loadAnimation(this, R.anim.your_custom_animation)
bottomBarPro.applyCustomAnimation(R.id.nav_send, customAnim)
```

## Customization

### Customizing Icons

You can customize the icons for each navigation item:

```kotlin
// Set custom icons
bottomBarPro.setHomeIcon(R.drawable.your_custom_home_icon)
bottomBarPro.setPersonIcon(R.drawable.your_custom_person_icon)
bottomBarPro.setAddIcon(R.drawable.your_custom_add_icon)
bottomBarPro.setBriefcaseIcon(R.drawable.your_custom_briefcase_icon)
bottomBarPro.setSendIcon(R.drawable.your_custom_send_icon)
```

### Customizing the Add Button Background

```kotlin
// Set a custom background for the add button
bottomBarPro.setAddButtonBackgroundColor(R.drawable.your_custom_background)
```

## Example Implementation

Here's a complete example of implementing BottomBarPro with fragments:

```kotlin
class MainActivity : AppCompatActivity(), BottomBarPro.OnNavigationItemClickListener {
    
    private lateinit var bottomBarPro: BottomBarPro
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        // Initialize BottomBarPro
        bottomBarPro = findViewById(R.id.bottom_bar_pro)
        
        // Set click listener
        bottomBarPro.setOnNavigationItemClickListener(this)
        
        // Load default fragment
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment())
                .commit()
        }
    }
    
    override fun onHomeClick() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeFragment())
            .commit()
    }
    
    override fun onPersonClick() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ProfileFragment())
            .commit()
    }
    
    override fun onAddClick() {
        // Show dialog or start new activity
        val dialog = CreatePostDialog()
        dialog.show(supportFragmentManager, "create_post_dialog")
    }
    
    override fun onBriefcaseClick() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, WorkFragment())
            .commit()
    }
    
    override fun onSendClick() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MessagesFragment())
            .commit()
    }
}
```

## Troubleshooting

If you encounter any issues:

1. Make sure you've properly included the library in your project
2. Ensure you're implementing the `BottomBarPro.OnNavigationItemClickListener` interface correctly
3. Check that you're setting the listener with `setOnNavigationItemClickListener(this)`
4. If animations aren't working, make sure you have the required animation resources in your project

## License

This library is distributed under the Apache License 2.0.

## Author

Developed by Samyak2403

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.
