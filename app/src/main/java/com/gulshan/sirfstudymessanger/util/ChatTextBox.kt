package com.gulshan.sirfstudymessanger.util

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatEditText

class ChatTextBox @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatEditText(context, attrs) {

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)

    }
}