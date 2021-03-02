package com.tencent.mm.plugin.appbrand.widget;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;

public class MMFalseProgressBar extends ProgressBar {
    private MMHandler mHandler;
    private boolean mIsStart;
    private float mProgress;
    private float olt;
    private float olu;
    private float olv;
    private float olw;
    private boolean olx;

    public MMFalseProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMFalseProgressBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(135398);
        this.mIsStart = false;
        this.mProgress = 0.0f;
        this.olx = true;
        this.mHandler = new MMHandler(Looper.getMainLooper()) {
            /* class com.tencent.mm.plugin.appbrand.widget.MMFalseProgressBar.AnonymousClass1 */

            /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
            @Override // com.tencent.mm.sdk.platformtools.MMHandler
            public final void handleMessage(Message message) {
                AppMethodBeat.i(135397);
                switch (message.what) {
                    case 1000:
                        MMFalseProgressBar.a(MMFalseProgressBar.this);
                        AppMethodBeat.o(135397);
                        return;
                    case 1001:
                        MMFalseProgressBar.b(MMFalseProgressBar.this);
                        AppMethodBeat.o(135397);
                        return;
                    case 1002:
                        MMFalseProgressBar.c(MMFalseProgressBar.this);
                        AppMethodBeat.o(135397);
                        return;
                    case 1003:
                        MMFalseProgressBar.d(MMFalseProgressBar.this);
                        break;
                }
                AppMethodBeat.o(135397);
            }
        };
        setMax(1000);
        if (NetStatusUtil.isWifiOr4G(MMApplicationContext.getContext())) {
            this.olt = 4.0f;
            this.olu = 1.0f;
            this.olv = 0.3f;
            this.olw = 50.0f;
            AppMethodBeat.o(135398);
            return;
        }
        this.olt = 2.0f;
        this.olu = 0.5f;
        this.olv = 0.15f;
        this.olw = 50.0f;
        AppMethodBeat.o(135398);
    }

    static /* synthetic */ void a(MMFalseProgressBar mMFalseProgressBar) {
        AppMethodBeat.i(135399);
        mMFalseProgressBar.setVisibility(0);
        mMFalseProgressBar.setAlpha(1.0f);
        AppMethodBeat.o(135399);
    }

    static /* synthetic */ void b(MMFalseProgressBar mMFalseProgressBar) {
        AppMethodBeat.i(135400);
        if (mMFalseProgressBar.mProgress < 600.0f) {
            mMFalseProgressBar.mProgress += mMFalseProgressBar.olt;
        } else if (mMFalseProgressBar.mProgress >= 600.0f && mMFalseProgressBar.mProgress < 800.0f) {
            mMFalseProgressBar.mProgress += mMFalseProgressBar.olu;
        } else if (mMFalseProgressBar.mProgress >= 800.0f && mMFalseProgressBar.mProgress < 920.0f) {
            mMFalseProgressBar.mProgress += mMFalseProgressBar.olv;
        }
        if (mMFalseProgressBar.mHandler != null) {
            if (mMFalseProgressBar.mProgress < 920.0f) {
                mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1001, 10);
            } else {
                mMFalseProgressBar.mHandler.removeMessages(1001);
            }
        }
        mMFalseProgressBar.setProgress((int) mMFalseProgressBar.mProgress);
        AppMethodBeat.o(135400);
    }

    static /* synthetic */ void c(MMFalseProgressBar mMFalseProgressBar) {
        Float valueOf;
        float f2 = 950.0f;
        AppMethodBeat.i(135401);
        if (mMFalseProgressBar.mIsStart) {
            if (mMFalseProgressBar.mProgress < 950.0f) {
                mMFalseProgressBar.mProgress += mMFalseProgressBar.olw;
                if (mMFalseProgressBar.mProgress <= 950.0f) {
                    f2 = mMFalseProgressBar.mProgress;
                }
                mMFalseProgressBar.mProgress = f2;
                valueOf = Float.valueOf(1.0f);
            } else {
                mMFalseProgressBar.mProgress += 1.0f;
                valueOf = Float.valueOf(((1000.0f - mMFalseProgressBar.mProgress) * 0.01f) + 0.3f);
            }
            if (mMFalseProgressBar.mHandler != null) {
                if (mMFalseProgressBar.mProgress < 1000.0f) {
                    mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1002, 10);
                } else {
                    mMFalseProgressBar.mProgress = 1000.0f;
                    mMFalseProgressBar.mHandler.removeMessages(1002);
                    mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(1003, 10);
                }
            }
            mMFalseProgressBar.setAlpha(valueOf.floatValue());
            mMFalseProgressBar.setProgress((int) mMFalseProgressBar.mProgress);
        }
        AppMethodBeat.o(135401);
    }

    static /* synthetic */ void d(MMFalseProgressBar mMFalseProgressBar) {
        AppMethodBeat.i(135402);
        mMFalseProgressBar.mProgress = 0.0f;
        mMFalseProgressBar.mIsStart = false;
        mMFalseProgressBar.postInvalidateDelayed(200);
        mMFalseProgressBar.setVisibility(8);
        AppMethodBeat.o(135402);
    }
}
