package com.tencent.mm.ui.widget.cedit.b;

import android.text.Spannable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.tencent.mm.ui.widget.cedit.edit.CustomTextView;

public interface d {
    void a(CustomTextView customTextView, Spannable spannable, int i2);

    boolean a(CustomTextView customTextView, Spannable spannable, int i2, KeyEvent keyEvent);

    boolean a(CustomTextView customTextView, Spannable spannable, KeyEvent keyEvent);

    boolean a(CustomTextView customTextView, Spannable spannable, MotionEvent motionEvent);

    boolean a(CustomTextView customTextView, MotionEvent motionEvent);

    boolean canSelectArbitrarily();

    void j(Spannable spannable);
}
