# BottomBarPro Documentation

## Overview

BottomBarPro is a customizable bottom navigation bar for Android applications featuring a stylish design with a prominent center action button and built-in animations. This documentation provides detailed information on how to integrate and use the library in your Android projects.

## Table of Contents

1. [Installation](#installation)
2. [Basic Implementation](#basic-implementation)
3. [Navigation Item Click Handling](#navigation-item-click-handling)
4. [Animations](#animations)
5. [Customization Options](#customization-options)
6. [API Reference](#api-reference)
7. [Troubleshooting](#troubleshooting)

## Installation

### Adding the Library to Your Project

#### Using Local Module

1. Add the library module to your `settings.gradle.kts`:
   ```kotlin
   include(":bottombarpro")
   ```

2. Add the dependency to your app's `build.gradle.kts`:
   ```kotlin
   dependencies {
       implementation(project(":bottombarpro"))
   }
   ```

#### Using Maven (After Publishing)

```kotlin
dependencies {
    implementation("com.samyak2403:bottombarpro:1.0.0")
}
```

## Basic Implementation

### XML Layout

Add the BottomBarPro view to your layout file:

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

Initialize the BottomBarPro in your Activity or Fragment:

```kotlin
// Initialize BottomBarPro
val bottomBarPro = findViewById<BottomBarPro>(R.id.bottom_bar_pro)
```

## Navigation Item Click Handling

### Implementing the Listener Interface

Your Activity or Fragment should implement the `BottomBarPro.OnNavigationItemClickListener` interface:

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

## Animations

BottomBarPro includes several built-in animations to enhance the user experience.

### Default Animations

- **Selection Animation**: When a navigation item is selected, it scales up while the previously selected item scales down
- **Add Button Animation**: The center add button has a special bounce animation when clicked

### Programmatic Selection with Animation

You can programmatically select an item with animation:

```kotlin
// Select the person icon programmatically
bottomBarPro.selectItem(R.id.nav_person)
```

### Custom Animations

You can apply additional animations to any navigation item:

```kotlin
// Apply rotation animation to a specific item
bottomBarPro.applyRotationAnimation(R.id.nav_add)

// Apply a custom animation to a specific item
val customAnim = AnimationUtils.loadAnimation(context, R.anim.your_custom_animation)
bottomBarPro.applyCustomAnimation(R.id.nav_send, customAnim)
```

### Animation Resources

The library uses the following animation resources:

1. `scale_up.xml`: Scales icons up when selected
2. `scale_down.xml`: Scales icons down when deselected
3. `bounce.xml`: Special bounce animation for the add button
4. `rotate.xml`: Rotation animation for additional visual feedback

## Customization Options

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

## API Reference

### BottomBarPro Class

The main class that represents the custom bottom navigation bar.

#### Constructors

```kotlin
BottomBarPro(context: Context)
BottomBarPro(context: Context, attrs: AttributeSet?)
BottomBarPro(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
```

#### Methods

| Method | Description |
|--------|-------------|
| `setOnNavigationItemClickListener(listener: OnNavigationItemClickListener)` | Sets the listener for navigation item clicks |
| `selectItem(itemId: Int)` | Programmatically selects a navigation item with animation |
| `setHomeIcon(resourceId: Int)` | Sets a custom icon for the home button |
| `setPersonIcon(resourceId: Int)` | Sets a custom icon for the person button |
| `setAddIcon(resourceId: Int)` | Sets a custom icon for the add button |
| `setBriefcaseIcon(resourceId: Int)` | Sets a custom icon for the briefcase button |
| `setSendIcon(resourceId: Int)` | Sets a custom icon for the send button |
| `setAddButtonBackgroundColor(colorRes: Int)` | Sets a custom background color for the add button |
| `applyCustomAnimation(itemId: Int, animation: Animation)` | Applies a custom animation to a specific navigation item |
| `applyRotationAnimation(itemId: Int)` | Applies a rotation animation to a specific item |

### OnNavigationItemClickListener Interface

Interface for handling navigation item clicks.

#### Methods

| Method | Description |
|--------|-------------|
| `onHomeClick()` | Called when the home button is clicked |
| `onPersonClick()` | Called when the person button is clicked |
| `onAddClick()` | Called when the add button is clicked |
| `onBriefcaseClick()` | Called when the briefcase button is clicked |
| `onSendClick()` | Called when the send button is clicked |

### Resource IDs

| ID | Description |
|----|-------------|
| `R.id.nav_home` | ID of the home button |
| `R.id.nav_person` | ID of the person button |
| `R.id.nav_add` | ID of the add button |
| `R.id.nav_briefcase` | ID of the briefcase button |
| `R.id.nav_send` | ID of the send button |
| `R.id.nav_add_container` | ID of the container for the add button |

## Troubleshooting

### Common Issues and Solutions

1. **ClassCastException when inflating BottomBarPro**
   - Make sure you have the latest version of the library
   - Ensure you have the correct dependencies in your app's build.gradle

2. **Animations not working**
   - Verify that the animation resources are correctly included in your project
   - Check that you're calling the animation methods correctly

3. **Click events not being triggered**
   - Ensure you've implemented the `OnNavigationItemClickListener` interface correctly
   - Verify that you've set the listener with `setOnNavigationItemClickListener(this)`

4. **Custom icons not showing**
   - Make sure your drawable resources exist in the correct directory
   - Check that you're using the correct resource IDs

### Support

If you encounter any issues not covered in this documentation, please open an issue on the GitHub repository or contact the author directly.

---

## Example Implementation with Fragments

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
