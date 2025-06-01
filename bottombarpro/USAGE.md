# BottomBarPro Usage Guide

This guide demonstrates how to use the BottomBarPro library in your Android projects.

## Basic Implementation

### Step 1: Add the library to your project

First, add the library as a dependency in your project. You can either use the local module or publish it to a Maven repository.

#### Using local module:

In your `settings.gradle.kts`:
```kotlin
include(":bottombarpro")
```

In your app's `build.gradle.kts`:
```kotlin
dependencies {
    implementation(project(":bottombarpro"))
}
```

#### Using Maven (after publishing):
```kotlin
dependencies {
    implementation("com.samyak2403:bottombarpro:1.0.0")
}
```

### Step 2: Add BottomBarPro to your layout

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

### Step 3: Implement the listener in your Activity

```kotlin
class YourActivity : AppCompatActivity(), BottomBarPro.OnNavigationItemClickListener {
    
    private lateinit var bottomBarPro: BottomBarPro
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.your_activity_layout)
        
        // Initialize BottomBarPro
        bottomBarPro = findViewById(R.id.bottom_bar_pro)
        
        // Set click listener
        bottomBarPro.setOnNavigationItemClickListener(this)
    }
    
    // Implement the required methods from the interface
    override fun onHomeClick() {
        // Example: Load home fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, HomeFragment())
            .commit()
    }
    
    override fun onPersonClick() {
        // Example: Load profile fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, ProfileFragment())
            .commit()
    }
    
    override fun onAddClick() {
        // Example: Show a dialog or start a new activity
        startActivity(Intent(this, CreatePostActivity::class.java))
    }
    
    override fun onBriefcaseClick() {
        // Example: Load work/jobs fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, WorkFragment())
            .commit()
    }
    
    override fun onSendClick() {
        // Example: Load messages fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MessagesFragment())
            .commit()
    }
}
```

## Advanced Usage

### Customizing Icons

You can customize the icons for each navigation item:

```kotlin
// In your activity's onCreate or wherever appropriate
bottomBarPro.setHomeIcon(R.drawable.custom_home_icon)
bottomBarPro.setPersonIcon(R.drawable.custom_profile_icon)
bottomBarPro.setAddIcon(R.drawable.custom_add_icon)
bottomBarPro.setBriefcaseIcon(R.drawable.custom_work_icon)
bottomBarPro.setSendIcon(R.drawable.custom_messages_icon)
```

### Customizing the Add Button Background

```kotlin
bottomBarPro.setAddButtonBackgroundColor(R.drawable.custom_button_background)
```

## Example Project

Check out the sample app in this repository for a complete implementation example.

## Troubleshooting

If you encounter any issues:

1. Make sure you've properly included the library in your project
2. Ensure you're implementing the `BottomBarPro.OnNavigationItemClickListener` interface correctly
3. Check that you're setting the listener with `setOnNavigationItemClickListener(this)`

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.
