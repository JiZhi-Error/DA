package com.tencent.mm.ui.widget.cedit.api;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.InputConnection;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.edittext.a;
import java.util.List;

public interface c {

    public interface a {
        boolean ZY(int i2);
    }

    void CS(boolean z);

    void a(a aVar);

    void a(List<String> list, List<String> list2, String str, a.e eVar);

    void addOnLayoutChangeListener(View.OnLayoutChangeListener onLayoutChangeListener);

    void addTextChangedListener(TextWatcher textWatcher);

    void append(CharSequence charSequence);

    void bol(String str);

    void clearComposingText();

    void clearFocus();

    void destroy();

    void gYF();

    View gYG();

    boolean gYH();

    ViewParent gYI();

    boolean gYJ();

    Context gYK();

    int gYL();

    CharSequence getContentDescription();

    CharSequence getHint();

    int getImeOptions();

    InputConnection getInputConnection();

    Bundle getInputExtras(boolean z);

    int getInputType();

    int getLineCount();

    TextPaint getPaint();

    CharSequence getPasterContent();

    int getPasterLen();

    int getSelectionStart();

    Editable getText();

    float getTextSize();

    int getVisibility();

    int length();

    void onPause();

    void refresh(boolean z);

    void removeOnLayoutChangeListener(View.OnLayoutChangeListener onLayoutChangeListener);

    void removeTextChangedListener(TextWatcher textWatcher);

    void setAlpha(float f2);

    void setBackListener(MMEditText.a aVar);

    void setBreakStrategy(int i2);

    void setContentDescription(CharSequence charSequence);

    void setCustomSelectionActionModeCallback(ActionMode.Callback callback);

    void setEnableSendBtn(boolean z);

    void setFilters(InputFilter[] inputFilterArr);

    void setHint(CharSequence charSequence);

    void setImeOptions(int i2);

    void setInputType(int i2);

    void setKeyCodeEnterListener(MMEditText.d dVar);

    void setMaxHeight(int i2);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnDragListener(View.OnDragListener onDragListener);

    void setOnFocusChangeListener(View.OnFocusChangeListener onFocusChangeListener);

    void setOnLongClickListener(View.OnLongClickListener onLongClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setPasterLen(int i2);

    void setSelection(int i2);

    void setText(CharSequence charSequence);

    void setTextColor(int i2);

    void setTextSize(int i2, float f2);

    void setVisibility(int i2);
}
