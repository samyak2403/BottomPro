# BottomBarPro

A stylish custom bottom navigation bar for Android with a prominent center action button.

## Features

- Modern, rounded black navigation bar
- Prominent blue circular add button in the center
- Clean white icons for better visibility
- Simple implementation with customizable icons
- Easy-to-use click listeners

## Installation

Add the library to your project by including it in your `settings.gradle.kts` file:

```kotlin
include(":bottombarpro")
```

Then add the dependency to your app's `build.gradle.kts` file:

```kotlin
dependencies {
    implementation(project(":bottombarpro"))
}
```

## Usage

### XML Layout

Add the BottomBarPro to your layout:

```xml
<com.samyak2403.bottombarpro.BottomBarPro
    android:id="@+id/bottom_bar_pro"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent" />
```

### Kotlin Implementation

Implement the OnNavigationItemClickListener in your Activity or Fragment:

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
    
    // BottomBarPro.OnNavigationItemClickListener implementation
    override fun onHomeClick() {
        // Handle home click
    }
    
    override fun onPersonClick() {
        // Handle person click
    }
    
    override fun onAddClick() {
        // Handle add click
    }
    
    override fun onBriefcaseClick() {
        // Handle briefcase click
    }
    
    override fun onSendClick() {
        // Handle send click
    }
}
```

## Customization

You can customize the icons using the provided methods:

```kotlin
// Set custom icons
bottomBarPro.setHomeIcon(R.drawable.your_custom_home_icon)
bottomBarPro.setPersonIcon(R.drawable.your_custom_person_icon)
bottomBarPro.setAddIcon(R.drawable.your_custom_add_icon)
bottomBarPro.setBriefcaseIcon(R.drawable.your_custom_briefcase_icon)
bottomBarPro.setSendIcon(R.drawable.your_custom_send_icon)

// Set custom add button background color
bottomBarPro.setAddButtonBackgroundColor(R.drawable.your_custom_background)
```

## License

This library is distributed under the Apache License 2.0.

## Author

Developed by Samyak2403
