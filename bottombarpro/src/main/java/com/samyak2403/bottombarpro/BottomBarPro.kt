package com.samyak2403.bottombarpro

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout

/**
 * A custom bottom navigation bar with a stylish design featuring a prominent center action button.
 * Includes selection animations for enhanced user experience.
 */
class BottomBarPro @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private lateinit var rootView: View
    private lateinit var homeButton: ImageView
    private lateinit var personButton: ImageView
    private lateinit var addButton: ImageView
    private lateinit var briefcaseButton: ImageView
    private lateinit var sendButton: ImageView
    private lateinit var addContainer: FrameLayout
    
    // Animation objects
    private lateinit var scaleUpAnim: Animation
    private lateinit var scaleDownAnim: Animation
    private lateinit var bounceAnim: Animation
    private lateinit var rotateAnim: Animation
    
    // Track currently selected item
    private var currentSelectedItem: ImageView? = null

    // Listener interface for navigation item clicks
    interface OnNavigationItemClickListener {
        fun onHomeClick()
        fun onPersonClick()
        fun onAddClick()
        fun onBriefcaseClick()
        fun onSendClick()
    }

    private var navigationItemClickListener: OnNavigationItemClickListener? = null

    init {
        initView()
    }
    
    private fun initView() {
        // Inflate the layout
        val inflater = LayoutInflater.from(context)
        rootView = inflater.inflate(R.layout.bottom_bar_pro, this, true)

        // Initialize views
        homeButton = findViewById(R.id.nav_home)
        personButton = findViewById(R.id.nav_person)
        addButton = findViewById(R.id.nav_add)
        briefcaseButton = findViewById(R.id.nav_briefcase)
        sendButton = findViewById(R.id.nav_send)
        addContainer = findViewById(R.id.nav_add_container)
        
        try {
            // Initialize animations
            scaleUpAnim = AnimationUtils.loadAnimation(context, R.anim.scale_up)
            scaleDownAnim = AnimationUtils.loadAnimation(context, R.anim.scale_down)
            bounceAnim = AnimationUtils.loadAnimation(context, R.anim.bounce)
            rotateAnim = AnimationUtils.loadAnimation(context, R.anim.rotate)
            
            // Set home as initially selected
            currentSelectedItem = homeButton
            homeButton.startAnimation(scaleUpAnim)
        } catch (e: Exception) {
            // Handle exception gracefully
            e.printStackTrace()
        }

        // Set up click listeners
        setupClickListeners()
    }

    private fun setupClickListeners() {
        try {
            homeButton.setOnClickListener {
                animateItemSelection(homeButton)
                navigationItemClickListener?.onHomeClick()
            }

            personButton.setOnClickListener {
                animateItemSelection(personButton)
                navigationItemClickListener?.onPersonClick()
            }

            addButton.setOnClickListener {
                // Special animation for add button
                if (::bounceAnim.isInitialized) {
                    addContainer.startAnimation(bounceAnim)
                }
                navigationItemClickListener?.onAddClick()
            }

            briefcaseButton.setOnClickListener {
                animateItemSelection(briefcaseButton)
                navigationItemClickListener?.onBriefcaseClick()
            }

            sendButton.setOnClickListener {
                animateItemSelection(sendButton)
                navigationItemClickListener?.onSendClick()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    
    /**
     * Animate the selection of a navigation item
     */
    private fun animateItemSelection(selectedItem: ImageView) {
        try {
            // Skip if same item is selected
            if (currentSelectedItem == selectedItem) return
            
            // Animate previous selection down
            currentSelectedItem?.let {
                if (it != addButton) { // Don't animate add button down
                    if (::scaleDownAnim.isInitialized) {
                        it.startAnimation(scaleDownAnim)
                    }
                }
            }
            
            // Animate new selection up
            if (selectedItem != addButton) { // Add button has its own animation
                if (::scaleUpAnim.isInitialized) {
                    selectedItem.startAnimation(scaleUpAnim)
                }
            }
            
            // Update current selection
            currentSelectedItem = selectedItem
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    
    /**
     * Manually select a specific navigation item with animation
     */
    fun selectItem(itemId: Int) {
        try {
            when (itemId) {
                R.id.nav_home -> animateItemSelection(homeButton)
                R.id.nav_person -> animateItemSelection(personButton)
                R.id.nav_add -> if (::bounceAnim.isInitialized) addContainer.startAnimation(bounceAnim)
                R.id.nav_briefcase -> animateItemSelection(briefcaseButton)
                R.id.nav_send -> animateItemSelection(sendButton)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * Set a listener for navigation item clicks
     */
    fun setOnNavigationItemClickListener(listener: OnNavigationItemClickListener) {
        this.navigationItemClickListener = listener
    }

    /**
     * Set a custom icon for the home button
     */
    fun setHomeIcon(resourceId: Int) {
        homeButton.setImageResource(resourceId)
    }

    /**
     * Set a custom icon for the person button
     */
    fun setPersonIcon(resourceId: Int) {
        personButton.setImageResource(resourceId)
    }

    /**
     * Set a custom icon for the add button
     */
    fun setAddIcon(resourceId: Int) {
        addButton.setImageResource(resourceId)
    }

    /**
     * Set a custom icon for the briefcase button
     */
    fun setBriefcaseIcon(resourceId: Int) {
        briefcaseButton.setImageResource(resourceId)
    }

    /**
     * Set a custom icon for the send button
     */
    fun setSendIcon(resourceId: Int) {
        sendButton.setImageResource(resourceId)
    }

    /**
     * Set a custom background color for the add button
     */
    fun setAddButtonBackgroundColor(colorRes: Int) {
        addContainer.setBackgroundResource(colorRes)
    }
    
    /**
     * Apply a custom animation to a specific navigation item
     */
    fun applyCustomAnimation(itemId: Int, animation: Animation) {
        try {
            when (itemId) {
                R.id.nav_home -> homeButton.startAnimation(animation)
                R.id.nav_person -> personButton.startAnimation(animation)
                R.id.nav_add -> addButton.startAnimation(animation)
                R.id.nav_briefcase -> briefcaseButton.startAnimation(animation)
                R.id.nav_send -> sendButton.startAnimation(animation)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    
    /**
     * Apply rotation animation to a specific item
     */
    fun applyRotationAnimation(itemId: Int) {
        try {
            if (::rotateAnim.isInitialized) {
                when (itemId) {
                    R.id.nav_home -> homeButton.startAnimation(rotateAnim)
                    R.id.nav_person -> personButton.startAnimation(rotateAnim)
                    R.id.nav_add -> addButton.startAnimation(rotateAnim)
                    R.id.nav_briefcase -> briefcaseButton.startAnimation(rotateAnim)
                    R.id.nav_send -> sendButton.startAnimation(rotateAnim)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}
