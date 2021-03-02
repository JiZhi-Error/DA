package com.tencent.wxa.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.wxa.c.a;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.android.j;
import io.flutter.embedding.engine.b.b;

public class WxaFlutterSplashView extends FrameLayout {
    private j Syh;
    private View Syi;
    private String Syj;
    private final FlutterView.a Syk;
    private final Runnable Syl;
    private String previousCompletedSplashIsolate;
    private Bundle splashScreenState;
    private final b wJo;
    private FlutterView wKM;

    public WxaFlutterSplashView(Context context) {
        this(context, null, 0);
    }

    public WxaFlutterSplashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WxaFlutterSplashView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(206392);
        this.Syk = new FlutterView.a() {
            /* class com.tencent.wxa.ui.WxaFlutterSplashView.AnonymousClass1 */

            @Override // io.flutter.embedding.android.FlutterView.a
            public final void hrW() {
                AppMethodBeat.i(206385);
                WxaFlutterSplashView.this.wKM.b(this);
                WxaFlutterSplashView.this.a(WxaFlutterSplashView.this.wKM, WxaFlutterSplashView.this.Syh);
                AppMethodBeat.o(206385);
            }
        };
        this.wJo = new b() {
            /* class com.tencent.wxa.ui.WxaFlutterSplashView.AnonymousClass2 */

            @Override // io.flutter.embedding.engine.b.b
            public final void dLt() {
                AppMethodBeat.i(206386);
                if (WxaFlutterSplashView.this.Syh != null) {
                    WxaFlutterSplashView.c(WxaFlutterSplashView.this);
                }
                AppMethodBeat.o(206386);
            }

            @Override // io.flutter.embedding.engine.b.b
            public final void dLu() {
            }
        };
        this.Syl = new Runnable() {
            /* class com.tencent.wxa.ui.WxaFlutterSplashView.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(206387);
                WxaFlutterSplashView.this.removeView(WxaFlutterSplashView.this.Syi);
                WxaFlutterSplashView.this.previousCompletedSplashIsolate = WxaFlutterSplashView.this.Syj;
                AppMethodBeat.o(206387);
            }
        };
        setSaveEnabled(true);
        AppMethodBeat.o(206392);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        AppMethodBeat.i(206393);
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.previousCompletedSplashIsolate = this.previousCompletedSplashIsolate;
        savedState.splashScreenState = null;
        AppMethodBeat.o(206393);
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(206394);
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.previousCompletedSplashIsolate = savedState.previousCompletedSplashIsolate;
        this.splashScreenState = savedState.splashScreenState;
        AppMethodBeat.o(206394);
    }

    public final void a(FlutterView flutterView, j jVar) {
        AppMethodBeat.i(206395);
        if (this.wKM != null) {
            this.wKM.b(this.wJo);
            removeView(this.wKM);
        }
        if (this.Syi != null) {
            removeView(this.Syi);
        }
        this.wKM = flutterView;
        addView(flutterView);
        this.Syh = jVar;
        if (jVar != null) {
            if (hrT()) {
                a.v("WxaRouter.WxaFlutterSplashView", "Showing splash screen UI.", new Object[0]);
                this.Syi = jVar.lM(getContext());
                addView(this.Syi);
                flutterView.a(this.wJo);
                AppMethodBeat.o(206395);
                return;
            }
            hrU();
            if (!flutterView.hwA()) {
                a.v("WxaRouter.WxaFlutterSplashView", "FlutterView is not yet attached to a FlutterEngine. Showing nothing until a FlutterEngine is attached.", new Object[0]);
                flutterView.a(this.Syk);
            }
        }
        AppMethodBeat.o(206395);
    }

    private boolean hrT() {
        AppMethodBeat.i(206396);
        if (this.wKM == null || !this.wKM.hwA() || this.wKM.SNn || hrV()) {
            AppMethodBeat.o(206396);
            return false;
        }
        AppMethodBeat.o(206396);
        return true;
    }

    private boolean hrU() {
        AppMethodBeat.i(206397);
        if (this.wKM != null) {
            this.wKM.hwA();
        }
        AppMethodBeat.o(206397);
        return false;
    }

    private boolean hrV() {
        AppMethodBeat.i(206398);
        if (this.wKM == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
            AppMethodBeat.o(206398);
            throw illegalStateException;
        } else if (!this.wKM.hwA()) {
            IllegalStateException illegalStateException2 = new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
            AppMethodBeat.o(206398);
            throw illegalStateException2;
        } else if (this.wKM.getAttachedFlutterEngine().SNW.SOJ == null || !this.wKM.getAttachedFlutterEngine().SNW.SOJ.equals(this.previousCompletedSplashIsolate)) {
            AppMethodBeat.o(206398);
            return false;
        } else {
            AppMethodBeat.o(206398);
            return true;
        }
    }

    public static class SavedState extends View.BaseSavedState {
        public static Parcelable.Creator CREATOR = new Parcelable.Creator() {
            /* class com.tencent.wxa.ui.WxaFlutterSplashView.SavedState.AnonymousClass1 */

            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new SavedState[i2];
            }

            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.i(206388);
                SavedState savedState = new SavedState(parcel);
                AppMethodBeat.o(206388);
                return savedState;
            }
        };
        private String previousCompletedSplashIsolate;
        private Bundle splashScreenState;

        static {
            AppMethodBeat.i(206391);
            AppMethodBeat.o(206391);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            AppMethodBeat.i(206389);
            this.previousCompletedSplashIsolate = parcel.readString();
            this.splashScreenState = parcel.readBundle(getClass().getClassLoader());
            AppMethodBeat.o(206389);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(206390);
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.previousCompletedSplashIsolate);
            parcel.writeBundle(this.splashScreenState);
            AppMethodBeat.o(206390);
        }
    }

    static /* synthetic */ void c(WxaFlutterSplashView wxaFlutterSplashView) {
        AppMethodBeat.i(206399);
        wxaFlutterSplashView.Syj = wxaFlutterSplashView.wKM.getAttachedFlutterEngine().SNW.SOJ;
        a.v("WxaRouter.WxaFlutterSplashView", "Transitioning splash screen to a Flutter UI. Isolate: " + wxaFlutterSplashView.Syj, new Object[0]);
        wxaFlutterSplashView.Syh.bc(wxaFlutterSplashView.Syl);
        AppMethodBeat.o(206399);
    }
}
