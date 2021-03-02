package com.tencent.mm.plugin.voip.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.voip.b.k;
import com.tencent.mm.plugin.voip.video.OpenGlRender;
import com.tencent.mm.plugin.voip.video.camera.prev.CaptureView;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.ui.ao;
import java.lang.ref.WeakReference;

public abstract class VoipBaseFragment extends Fragment {
    protected static final int[] HeB = {-1, R.string.i3w, R.string.i4m, R.string.i4l};
    static int HeF = -1;
    protected static int mScreenHeight;
    protected static int mScreenWidth;
    protected boolean GUf;
    protected ImageView HeC;
    protected ImageView HeD;
    protected int HeE = 4096;
    protected d HeG;
    protected c HeH = new c();
    private a HeI;
    private b HeJ;
    protected WeakReference<c> Hen;
    protected long Heo = -1;
    protected String goe;
    protected MMHandler kAn;
    protected int mStatus = -1;
    protected RelativeLayout ncd;

    public interface d {
        void aI(boolean z, boolean z2);
    }

    /* access modifiers changed from: protected */
    public abstract void aUB(String str);

    /* access modifiers changed from: protected */
    public abstract void fJq();

    /* access modifiers changed from: protected */
    public abstract void jE(int i2, int i3);

    public abstract void m(Point point);

    public abstract void setMute(boolean z);

    public abstract void setVoicePlayDevice(int i2);

    /* access modifiers changed from: protected */
    public abstract void xk(boolean z);

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.goe = arguments.getString("key_username");
        this.GUf = arguments.getBoolean("key_isoutcall");
        if (-1 == this.mStatus) {
            this.mStatus = arguments.getInt("key_status");
        }
        this.kAn = new MMHandler();
    }

    @Override // android.support.v4.app.Fragment
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (Build.VERSION.SDK_INT >= 23) {
            Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            mScreenWidth = displayMetrics.widthPixels;
            mScreenHeight = displayMetrics.heightPixels;
        } else if (mScreenWidth == 0) {
            Display defaultDisplay2 = activity.getWindowManager().getDefaultDisplay();
            mScreenWidth = defaultDisplay2.getWidth();
            mScreenHeight = defaultDisplay2.getHeight();
        }
    }

    public void jD(int i2, int i3) {
        Log.printInfoStack("MicroMsg.VoipBaseFragment", "newState: " + k.adM(i3) + ", action: " + k.adM(i2) + ", lastStatus: " + k.adM(HeF), new Object[0]);
        if (!(HeF == this.mStatus || i3 == this.mStatus)) {
            HeF = this.mStatus;
        }
        this.HeE = i2;
        this.mStatus = i3;
    }

    public final void Li(long j2) {
        this.Heo = j2;
    }

    public void uninit() {
        Log.d("MicroMsg.VoipBaseFragment", "uninit");
        this.HeH.fJB();
        c cVar = this.HeH;
        Log.d("MicroMsg.DynamicTextWrap", "uninit");
        cVar.fJB();
        cVar.cve = null;
        if (this.HeI != null) {
            this.HeI.cancel();
            this.HeI = null;
        }
        if (this.HeJ != null) {
            this.HeJ.cancel();
            this.HeJ = null;
        }
    }

    @Deprecated
    public void a(CaptureView captureView) {
    }

    @Deprecated
    public void fJx() {
    }

    @Deprecated
    public void setVoipBeauty(int i2) {
    }

    @Deprecated
    public void setSpatiotemporalDenosing(int i2) {
    }

    @Deprecated
    public void setHWDecMode(int i2) {
    }

    @Deprecated
    public void a(SurfaceTexture surfaceTexture, com.tencent.mm.media.g.d dVar) {
    }

    @Deprecated
    public void requestRender() {
    }

    @Deprecated
    public void releaseSurfaceTexture() {
    }

    @Deprecated
    public void jA(int i2, int i3) {
    }

    @Deprecated
    public void b(byte[] bArr, long j2, int i2, int i3, int i4, int i5, int i6) {
    }

    @Deprecated
    public OpenGlRender fJy() {
        return null;
    }

    @Deprecated
    public OpenGlRender getSpatioTemporalFilterData() {
        return null;
    }

    @Deprecated
    public void f(int i2, int i3, byte[] bArr) {
    }

    @Override // android.support.v4.app.Fragment
    public void onDetach() {
        if (this.kAn != null) {
            this.kAn.removeCallbacksAndMessages(null);
        }
        this.HeG = null;
        super.onDetach();
    }

    public void setDeviceOrientation(int i2) {
    }

    public void fJm() {
    }

    public void adx(int i2) {
    }

    public void ady(int i2) {
    }

    public void adz(int i2) {
    }

    public final void setVoipUIListener(c cVar) {
        this.Hen = new WeakReference<>(cVar);
    }

    public final void a(d dVar) {
        this.HeG = dVar;
    }

    /* access modifiers changed from: protected */
    public final void z(TextView textView) {
        if (textView == null) {
            Log.e("MicroMsg.VoipBaseFragment", "TextView is null or text is null");
            return;
        }
        textView.setText(R.string.i4l);
        textView.measure(View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().widthPixels, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(getResources().getDisplayMetrics().heightPixels, Integer.MIN_VALUE));
        textView.setWidth(textView.getMeasuredWidth());
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    /* access modifiers changed from: protected */
    public final void fJz() {
        if (this.goe != null && this.HeC.getVisibility() != 0) {
            this.HeC.setVisibility(0);
            this.HeI = new a();
            h.RTc.aX(this.HeI);
        }
    }

    /* access modifiers changed from: protected */
    public final void fJA() {
        this.HeD.setVisibility(0);
        this.HeJ = new b();
        h.RTc.aX(this.HeJ);
    }

    protected static String AF(long j2) {
        return String.format("%02d:%02d", Long.valueOf(j2 / 60), Long.valueOf(j2 % 60));
    }

    /* access modifiers changed from: protected */
    public static class c {
        int[] HeN;
        private int HeO;
        int HeP;
        TextView Ws;
        MTimerHandler cve = new MTimerHandler(new MTimerHandler.CallBack() {
            /* class com.tencent.mm.plugin.voip.ui.VoipBaseFragment.c.AnonymousClass1 */

            @Override // com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack
            public final boolean onTimerExpired() {
                AppMethodBeat.i(115370);
                int i2 = c.this.HeN[c.this.HeP % c.this.HeN.length];
                if (c.this.Ws != null) {
                    if (-1 == i2) {
                        c.this.Ws.setText((CharSequence) null);
                    } else {
                        c.this.Ws.setText(i2);
                    }
                }
                c.this.HeP++;
                AppMethodBeat.o(115370);
                return true;
            }
        }, true);

        protected c() {
            AppMethodBeat.i(115371);
            AppMethodBeat.o(115371);
        }

        public final void a(TextView textView, int[] iArr) {
            AppMethodBeat.i(115372);
            if (iArr == null || textView == null) {
                Log.e("MicroMsg.DynamicTextWrap", "textList or tv is null");
                AppMethodBeat.o(115372);
                return;
            }
            fJB();
            this.HeP = 0;
            this.HeN = iArr;
            this.Ws = textView;
            this.HeO = 500;
            if (this.cve != null) {
                this.cve.startTimer((long) this.HeO);
            }
            Log.printDebugStack("MicroMsg.DynamicTextWrap", "start textview:".concat(String.valueOf(textView)), new Object[0]);
            AppMethodBeat.o(115372);
        }

        public final void fJB() {
            AppMethodBeat.i(115373);
            if (this.cve != null) {
                this.cve.stopTimer();
            }
            Log.printDebugStack("MicroMsg.DynamicTextWrap", "stop textview: " + this.Ws, new Object[0]);
            this.Ws = null;
            AppMethodBeat.o(115373);
        }
    }

    public class a extends com.tencent.f.i.b {
        public a() {
        }

        public final void run() {
            AppMethodBeat.i(115367);
            Log.i("MicroMsg.VoipBaseFragment", "try load blur bitmap,timestamp: " + System.currentTimeMillis());
            Bitmap a2 = com.tencent.mm.aj.c.a(VoipBaseFragment.this.goe, false, -1, null);
            if (a2 == null || VoipBaseFragment.this.ncd == null) {
                AppMethodBeat.o(115367);
                return;
            }
            int i2 = 0;
            while (true) {
                if ((VoipBaseFragment.this.ncd.getHeight() == 0 || VoipBaseFragment.this.ncd.getWidth() == 0) && i2 < 10) {
                    try {
                        Thread.sleep(300);
                        i2++;
                    } catch (InterruptedException e2) {
                        Log.e("MicroMsg.VoipBaseFragment", "wait voip initialize interrupted");
                        AppMethodBeat.o(115367);
                        return;
                    }
                }
            }
            if (a2.getHeight() <= a2.getWidth() && a2.getHeight() / 5 > 0 && ((int) (((double) a2.getHeight()) * 0.6d)) > 0) {
                a2 = Bitmap.createBitmap(a2, a2.getWidth() / 5, a2.getHeight() / 5, (int) (((double) a2.getHeight()) * 0.6d), (int) (((double) a2.getHeight()) * 0.6d), (Matrix) null, false);
            }
            Bitmap extractThumbNail = BitmapUtil.extractThumbNail(a2, a2.getHeight(), (int) (((float) a2.getHeight()) / (((float) ao.az(MMApplicationContext.getContext()).y) / ((float) ao.az(MMApplicationContext.getContext()).x))), true, false);
            if (extractThumbNail == null) {
                Log.e("MicroMsg.VoipBaseFragment", "extract Thumb Nail for blur background failed");
                AppMethodBeat.o(115367);
                return;
            }
            try {
                final Bitmap fastblur = BitmapUtil.fastblur(extractThumbNail, 20);
                Log.i("MicroMsg.VoipBaseFragment", "blur ok, timestamp: " + System.currentTimeMillis());
                VoipBaseFragment.this.kAn.post(new Runnable() {
                    /* class com.tencent.mm.plugin.voip.ui.VoipBaseFragment.a.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(115366);
                        if (VoipBaseFragment.this.HeC != null) {
                            VoipBaseFragment.this.HeC.setBackgroundDrawable(new BitmapDrawable(fastblur));
                            VoipBaseFragment.this.HeC.getBackground().setAlpha(128);
                        }
                        VoipBaseFragment.this.HeI = null;
                        AppMethodBeat.o(115366);
                    }
                });
                AppMethodBeat.o(115367);
            } catch (Exception e3) {
                Log.e("MicroMsg.VoipBaseFragment", "fastblur failed: " + e3.getMessage());
                AppMethodBeat.o(115367);
            }
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "VoipBaseFragment_blurbitmap";
        }
    }

    public class b extends com.tencent.f.i.b {
        public b() {
        }

        public final void run() {
            AppMethodBeat.i(115369);
            Log.i("MicroMsg.VoipBaseFragment", "try create blur bitmap,timestamp: " + System.currentTimeMillis());
            final Bitmap bitmapNative = BitmapUtil.getBitmapNative((int) R.drawable.cqc);
            Log.i("MicroMsg.VoipBaseFragment", "blur transparent ok, timestamp: " + System.currentTimeMillis());
            VoipBaseFragment.this.kAn.post(new Runnable() {
                /* class com.tencent.mm.plugin.voip.ui.VoipBaseFragment.b.AnonymousClass1 */

                public final void run() {
                    AppMethodBeat.i(115368);
                    if (VoipBaseFragment.this.HeD != null) {
                        VoipBaseFragment.this.HeD.setBackgroundDrawable(new BitmapDrawable(bitmapNative));
                        VoipBaseFragment.this.HeD.getBackground().setAlpha(230);
                        VoipBaseFragment.this.HeD.getBackground().setFilterBitmap(true);
                    }
                    VoipBaseFragment.this.HeJ = null;
                    AppMethodBeat.o(115368);
                }
            });
            AppMethodBeat.o(115369);
        }

        @Override // com.tencent.f.i.h, com.tencent.f.i.g
        public final String getKey() {
            return "VoipBaseFragment_blurtransparentbitmap";
        }
    }

    protected static void aA(View view, int i2) {
        if (view != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
            layoutParams.topMargin += i2;
            view.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: package-private */
    public void adB(int i2) {
    }
}
