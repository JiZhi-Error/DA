package com.tencent.mm.pluginsdk.ui.span;

import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.applet.u;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.span.a;
import java.lang.ref.WeakReference;

public class p extends ClickableSpan implements a {
    private static final String TAG = "MicroMsg.PressableClickSpan";
    private boolean isPressed = false;
    private a mAdTagClickCallback;
    private int mAdTagClickScene;
    private int mBgColor;
    protected j mClickListener = null;
    private boolean mEnable = true;
    private u mHrefInfo = null;
    private int mLinkColor;
    private String mSessionId;
    private WeakReference<View> mViewRef = null;
    private int position;
    private Object tag = null;
    private Context uiContext = null;

    public void setTag(Object obj) {
        this.tag = obj;
    }

    public Object getTag() {
        return this.tag;
    }

    public p() {
    }

    public p(int i2, u uVar) {
        int i3;
        int i4;
        AppMethodBeat.i(152339);
        if (uVar != null) {
            int i5 = uVar.linkColor;
            i3 = uVar.backgroundColor;
            i4 = i5;
        } else {
            i3 = 0;
            i4 = 0;
        }
        setColorConfig(i2, i4, i3);
        this.mClickListener = new j();
        this.mHrefInfo = uVar;
        AppMethodBeat.o(152339);
    }

    public p(int i2, int i3) {
        AppMethodBeat.i(152340);
        setColor(i2, i3);
        this.mClickListener = new j();
        AppMethodBeat.o(152340);
    }

    private void setColorConfig(int i2, int i3, int i4) {
        AppMethodBeat.i(152341);
        if (i3 == 0 && i4 == 0) {
            setColorConfig(i2);
            AppMethodBeat.o(152341);
            return;
        }
        setColor(i3, i4);
        AppMethodBeat.o(152341);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: protected */
    public void setColorConfig(int i2) {
        AppMethodBeat.i(152342);
        Context context = MMApplicationContext.getContext();
        switch (i2) {
            case 1:
                setColor(context.getResources().getColor(R.color.j2), context.getResources().getColor(R.color.BW_0_Alpha_0_1));
                AppMethodBeat.o(152342);
                return;
            case 2:
                setColor(context.getResources().getColor(R.color.g7), context.getResources().getColor(R.color.a91));
                AppMethodBeat.o(152342);
                return;
            case 3:
                setColor(context.getResources().getColor(R.color.a9_), context.getResources().getColor(R.color.a91));
                setColor(context.getResources().getColor(R.color.ah1), context.getResources().getColor(R.color.a91));
                break;
            case 4:
                setColor(context.getResources().getColor(R.color.j1), context.getResources().getColor(R.color.BW_0_Alpha_0_1));
                AppMethodBeat.o(152342);
                return;
            case 5:
                setColor(context.getResources().getColor(R.color.ah1), context.getResources().getColor(R.color.a91));
                break;
        }
        AppMethodBeat.o(152342);
    }

    public void setColor(int i2, int i3) {
        this.mLinkColor = i2;
        this.mBgColor = i3;
    }

    @Override // com.tencent.mm.ui.base.span.a
    public void setIsPressed(boolean z) {
        this.isPressed = z;
    }

    public boolean getPress() {
        return this.isPressed;
    }

    public int getBgColor() {
        return this.mBgColor;
    }

    public int getType() {
        if (this.mHrefInfo == null) {
            return Integer.MAX_VALUE;
        }
        return this.mHrefInfo.type;
    }

    public void onClick(View view) {
        Context context;
        AppMethodBeat.i(152343);
        if (!(this.mClickListener == null || this.mHrefInfo == null || !this.mEnable)) {
            j jVar = this.mClickListener;
            if (this.uiContext != null) {
                context = this.uiContext;
            } else {
                context = view.getContext();
            }
            jVar.mContext = context;
            this.mClickListener.a(view, this.mHrefInfo);
            this.mClickListener.mContext = null;
        }
        if (this.mAdTagClickCallback != null) {
            this.mAdTagClickCallback.iL(this.position, this.mAdTagClickScene);
        }
        AppMethodBeat.o(152343);
    }

    public void updateDrawState(TextPaint textPaint) {
        AppMethodBeat.i(152344);
        if (Log.getLogLevel() <= 1) {
            Log.d(TAG, "updateDrawState, isPressed:%b", Boolean.valueOf(this.isPressed));
        }
        super.updateDrawState(textPaint);
        textPaint.setColor(this.mLinkColor);
        textPaint.setUnderlineText(false);
        textPaint.linkColor = this.mLinkColor;
        if (getPress()) {
            textPaint.bgColor = this.mBgColor;
            AppMethodBeat.o(152344);
            return;
        }
        textPaint.bgColor = 0;
        AppMethodBeat.o(152344);
    }

    public void setContext(Context context) {
        this.uiContext = context;
        if (this.mClickListener != null) {
            this.mClickListener.mContext = context;
        }
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void setSessionId(String str) {
        this.mSessionId = str;
        if (this.mClickListener != null) {
            this.mClickListener.mSessionId = this.mSessionId;
        }
    }

    public u getHrefInfo() {
        return this.mHrefInfo;
    }

    public void setAdTagClickCallback(a aVar, int i2) {
        this.mAdTagClickCallback = aVar;
        this.position = i2;
    }

    public void setAdTagClickScene(int i2) {
        this.mAdTagClickScene = i2;
    }
}
