package com.tencent.mm.plugin.appbrand.widget.input;

import android.content.Context;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.mm.plugin.appbrand.page.ac;

public interface ab {

    public interface a {
        void iE();
    }

    public interface b {
        boolean Aa(int i2);
    }

    public interface c {
        void cbA();
    }

    int Ak(int i2);

    void G(ac acVar);

    void H(ac acVar);

    void Q(float f2, float f3);

    void a(View.OnFocusChangeListener onFocusChangeListener);

    void a(a aVar);

    void a(c cVar);

    void addTextChangedListener(TextWatcher textWatcher);

    void b(View.OnFocusChangeListener onFocusChangeListener);

    boolean cbB();

    void cbQ();

    void cbR();

    void cbS();

    boolean cbx();

    boolean cby();

    void destroy();

    com.tencent.mm.plugin.appbrand.widget.input.autofill.b getAutoFillController();

    Context getContext();

    int getInputId();

    View getInputPanel();

    char getLastKeyPressed();

    CharSequence getText();

    View getView();

    void setFixed(boolean z);

    void setInputId(int i2);

    void setOnKeyUpPostImeListener(b bVar);
}
