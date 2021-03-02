package com.tencent.mm.pluginsdk.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.mm.pluginsdk.ui.chat.f;

public abstract class ChatFooterPanel extends LinearLayout {
    public static int BKM = 2;
    public static int BKN = KbB;
    public static int KbB = 0;
    public static int KbC = 1;
    public static int KbD = 3;
    public static int KbE = 4;
    public static int KbF = 5;
    public static int KbG = 6;
    public static int KbH = 12;
    public static int KbI = 7;
    public static int KbJ = 8;
    public static int KbK = 9;
    public static int KbL = 10;
    public static int KbM = 11;
    public static int KbN = 12;
    public static int KbO = 14;
    public static int KbP = 15;
    public static int tvw = 13;
    protected int IFI;
    protected f KbA;
    protected a Kbz;

    public interface a {
        void aHC();

        void aHD();

        void append(String str);

        void eP(boolean z);
    }

    public abstract void goC();

    @Deprecated
    public abstract void goD();

    @Deprecated
    public abstract void goE();

    public abstract void goF();

    public abstract void onPause();

    public abstract void onResume();

    public abstract void setDefaultEmojiByDetail(String str);

    public abstract void setEntranceScene(int i2);

    @Deprecated
    public abstract void setPortHeightPx(int i2);

    public abstract void setSendButtonEnable(boolean z);

    public abstract void setShowClose(boolean z);

    public abstract void setShowSend(boolean z);

    public abstract void setShowSmiley(boolean z);

    public abstract void setShowStore(boolean z);

    public abstract void setTalkerName(String str);

    public abstract void setToSendText(String str);

    @Deprecated
    public abstract void zN(boolean z);

    public ChatFooterPanel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnTextOperationListener(a aVar) {
        this.Kbz = aVar;
    }

    public void setCallback(f fVar) {
        this.KbA = fVar;
    }

    public void setFooterType(int i2) {
        this.IFI = i2;
    }

    public void destroy() {
    }

    public static abstract class RecommendView extends LinearLayout {
        public abstract void setProductID(String str);

        public RecommendView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public RecommendView(Context context, AttributeSet attributeSet, int i2) {
            super(context, attributeSet, i2);
        }
    }
}
