package io.flutter.embedding.android;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Keep;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.a;
import io.flutter.embedding.android.FlutterView;
import io.flutter.embedding.engine.b.b;

/* access modifiers changed from: package-private */
public final class FlutterSplashView extends FrameLayout {
    private static String TAG = "FlutterSplashView";
    private final b SMD;
    private j Syh;
    private View Syi;
    private String Syj;
    private final FlutterView.a Syk;
    private final Runnable Syl;
    private String previousCompletedSplashIsolate;
    private Bundle splashScreenState;
    private FlutterView wKM;

    public FlutterSplashView(Context context) {
        this(context, null, 0);
    }

    public FlutterSplashView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlutterSplashView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(10060);
        this.Syk = new FlutterView.a() {
            /* class io.flutter.embedding.android.FlutterSplashView.AnonymousClass1 */

            @Override // io.flutter.embedding.android.FlutterView.a
            public final void hrW() {
                AppMethodBeat.i(10025);
                FlutterSplashView.this.wKM.b(this);
                FlutterSplashView.this.a(FlutterSplashView.this.wKM, FlutterSplashView.this.Syh);
                AppMethodBeat.o(10025);
            }
        };
        this.SMD = new b() {
            /* class io.flutter.embedding.android.FlutterSplashView.AnonymousClass2 */

            @Override // io.flutter.embedding.engine.b.b
            public final void dLt() {
                AppMethodBeat.i(215094);
                if (FlutterSplashView.this.Syh != null) {
                    FlutterSplashView.c(FlutterSplashView.this);
                }
                AppMethodBeat.o(215094);
            }

            @Override // io.flutter.embedding.engine.b.b
            public final void dLu() {
            }
        };
        this.Syl = new Runnable() {
            /* class io.flutter.embedding.android.FlutterSplashView.AnonymousClass3 */

            public final void run() {
                AppMethodBeat.i(10113);
                FlutterSplashView.this.removeView(FlutterSplashView.this.Syi);
                FlutterSplashView.this.previousCompletedSplashIsolate = FlutterSplashView.this.Syj;
                AppMethodBeat.o(10113);
            }
        };
        setSaveEnabled(true);
        AppMethodBeat.o(10060);
    }

    /* access modifiers changed from: protected */
    public final Parcelable onSaveInstanceState() {
        AppMethodBeat.i(10061);
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.previousCompletedSplashIsolate = this.previousCompletedSplashIsolate;
        savedState.splashScreenState = null;
        AppMethodBeat.o(10061);
        return savedState;
    }

    /* access modifiers changed from: protected */
    public final void onRestoreInstanceState(Parcelable parcelable) {
        AppMethodBeat.i(10062);
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.previousCompletedSplashIsolate = savedState.previousCompletedSplashIsolate;
        this.splashScreenState = savedState.splashScreenState;
        AppMethodBeat.o(10062);
    }

    public final void a(FlutterView flutterView, j jVar) {
        AppMethodBeat.i(10063);
        if (this.wKM != null) {
            this.wKM.b(this.SMD);
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
                a.hwd();
                this.Syi = jVar.lM(getContext());
                addView(this.Syi);
                flutterView.a(this.SMD);
                AppMethodBeat.o(10063);
                return;
            }
            hrU();
            if (!flutterView.hwA()) {
                a.hwd();
                flutterView.a(this.Syk);
            }
        }
        AppMethodBeat.o(10063);
    }

    private boolean hrT() {
        AppMethodBeat.i(10064);
        if (this.wKM == null || !this.wKM.hwA() || this.wKM.SNn || hrV()) {
            AppMethodBeat.o(10064);
            return false;
        }
        AppMethodBeat.o(10064);
        return true;
    }

    private boolean hrU() {
        AppMethodBeat.i(215015);
        if (this.wKM != null) {
            this.wKM.hwA();
        }
        AppMethodBeat.o(215015);
        return false;
    }

    private boolean hrV() {
        AppMethodBeat.i(10065);
        if (this.wKM == null) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot determine if splash has completed when no FlutterView is set.");
            AppMethodBeat.o(10065);
            throw illegalStateException;
        } else if (!this.wKM.hwA()) {
            IllegalStateException illegalStateException2 = new IllegalStateException("Cannot determine if splash has completed when no FlutterEngine is attached to our FlutterView. This question depends on an isolate ID to differentiate Flutter experiences.");
            AppMethodBeat.o(10065);
            throw illegalStateException2;
        } else if (this.wKM.getAttachedFlutterEngine().SNW.SOJ == null || !this.wKM.getAttachedFlutterEngine().SNW.SOJ.equals(this.previousCompletedSplashIsolate)) {
            AppMethodBeat.o(10065);
            return false;
        } else {
            AppMethodBeat.o(10065);
            return true;
        }
    }

    @Keep
    public static class SavedState extends View.BaseSavedState {
        public static Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* class io.flutter.embedding.android.FlutterSplashView.SavedState.AnonymousClass1 */

            /* Return type fixed from 'java.lang.Object[]' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* bridge */ /* synthetic */ SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }

            /* Return type fixed from 'java.lang.Object' to match base method */
            @Override // android.os.Parcelable.Creator
            public final /* synthetic */ SavedState createFromParcel(Parcel parcel) {
                AppMethodBeat.i(10058);
                SavedState savedState = new SavedState(parcel);
                AppMethodBeat.o(10058);
                return savedState;
            }
        };
        private String previousCompletedSplashIsolate;
        private Bundle splashScreenState;

        static {
            AppMethodBeat.i(9966);
            AppMethodBeat.o(9966);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel) {
            super(parcel);
            AppMethodBeat.i(9964);
            this.previousCompletedSplashIsolate = parcel.readString();
            this.splashScreenState = parcel.readBundle(getClass().getClassLoader());
            AppMethodBeat.o(9964);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            AppMethodBeat.i(9965);
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.previousCompletedSplashIsolate);
            parcel.writeBundle(this.splashScreenState);
            AppMethodBeat.o(9965);
        }
    }

    static /* synthetic */ void c(FlutterSplashView flutterSplashView) {
        AppMethodBeat.i(10066);
        flutterSplashView.Syj = flutterSplashView.wKM.getAttachedFlutterEngine().SNW.SOJ;
        new StringBuilder("Transitioning splash screen to a Flutter UI. Isolate: ").append(flutterSplashView.Syj);
        a.hwd();
        flutterSplashView.Syh.bc(flutterSplashView.Syl);
        AppMethodBeat.o(10066);
    }
}
