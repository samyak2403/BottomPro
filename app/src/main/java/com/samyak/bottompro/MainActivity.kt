package com.samyak.bottompro

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.samyak2403.bottombarpro.BottomBarPro

class MainActivity : AppCompatActivity(), BottomBarPro.OnNavigationItemClickListener {
    
    private lateinit var bottomBarPro: BottomBarPro
    private val handler = Handler(Looper.getMainLooper())
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        // Set up system bars padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        
        // Set up BottomBarPro
        setupBottomBarPro()
    }
    
    private fun setupBottomBarPro() {
        // Initialize BottomBarPro
        bottomBarPro = findViewById(R.id.bottom_bar_pro)
        
        // Set click listener
        bottomBarPro.setOnNavigationItemClickListener(this)
        
        // Demonstrate programmatic selection after a delay
        handler.postDelayed({
            // Programmatically select the person icon after 2 seconds
            bottomBarPro.selectItem(R.id.nav_person)
            Toast.makeText(this, "Programmatically selected Profile", Toast.LENGTH_SHORT).show()
        }, 2000)
    }
    
    // BottomBarPro.OnNavigationItemClickListener implementation
    override fun onHomeClick() {
        Toast.makeText(this, "Home selected", Toast.LENGTH_SHORT).show()
    }
    
    override fun onPersonClick() {
        Toast.makeText(this, "Profile selected", Toast.LENGTH_SHORT).show()
    }
    
    override fun onAddClick() {
        Toast.makeText(this, "Add selected", Toast.LENGTH_SHORT).show()
        
        // Apply rotation animation to add button when clicked
        handler.postDelayed({
            bottomBarPro.applyRotationAnimation(R.id.nav_add)
        }, 300)
    }
    
    override fun onBriefcaseClick() {
        Toast.makeText(this, "Briefcase selected", Toast.LENGTH_SHORT).show()
    }
    
    override fun onSendClick() {
        Toast.makeText(this, "Send selected", Toast.LENGTH_SHORT).show()
        
        // Apply custom animation to demonstrate additional animation capabilities
        handler.postDelayed({
            // Create a custom animation for the send button
            val customAnim = AnimationUtils.loadAnimation(this, R.anim.rotate)
            bottomBarPro.applyCustomAnimation(R.id.nav_send, customAnim)
        }, 300)
    }
    
    override fun onDestroy() {
        super.onDestroy()
        // Remove any pending callbacks to prevent memory leaks
        handler.removeCallbacksAndMessages(null)
    }
}