package com.tencent.tbs.one.impl.b;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.optional.TBSOneDebugPlugin;

public final class a extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private final String f2382a;

    /* renamed from: b  reason: collision with root package name */
    private Handler f2383b = new Handler(Looper.getMainLooper());

    /* renamed from: c  reason: collision with root package name */
    private TextView f2384c;

    public a(Context context, String str) {
        super(context);
        AppMethodBeat.i(174167);
        this.f2382a = str;
        this.f2384c = new TextView(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.f2384c, layoutParams);
        com.tencent.tbs.one.impl.common.a.a(context, new TBSOneCallback<TBSOneDebugPlugin>() {
            /* class com.tencent.tbs.one.impl.b.a.AnonymousClass1 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            @Override // com.tencent.tbs.one.TBSOneCallback
            public final /* synthetic */ void onCompleted(TBSOneDebugPlugin tBSOneDebugPlugin) {
                AppMethodBeat.i(174161);
                final TBSOneDebugPlugin tBSOneDebugPlugin2 = tBSOneDebugPlugin;
                a.a(a.this, new Runnable() {
                    /* class com.tencent.tbs.one.impl.b.a.AnonymousClass1.AnonymousClass2 */

                    public final void run() {
                        AppMethodBeat.i(174166);
                        a.a(a.this);
                        View createDebuggingView = tBSOneDebugPlugin2.createDebuggingView(a.this.getContext(), a.this.f2382a);
                        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
                        layoutParams.gravity = 17;
                        a.this.addView(createDebuggingView, layoutParams);
                        a.a(a.this, "加载调试组件成功");
                        AppMethodBeat.o(174166);
                    }
                });
                AppMethodBeat.o(174161);
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onError(int i2, String str) {
                AppMethodBeat.i(174160);
                a.a(a.this, new Runnable() {
                    /* class com.tencent.tbs.one.impl.b.a.AnonymousClass1.AnonymousClass3 */

                    public final void run() {
                        AppMethodBeat.i(174162);
                        a.a(a.this);
                        a.a(a.this, "加载调试组件失败，请稍后重试");
                        AppMethodBeat.o(174162);
                    }
                });
                AppMethodBeat.o(174160);
            }

            @Override // com.tencent.tbs.one.TBSOneCallback
            public final void onProgressChanged(int i2, final int i3) {
                AppMethodBeat.i(174159);
                a.a(a.this, new Runnable() {
                    /* class com.tencent.tbs.one.impl.b.a.AnonymousClass1.AnonymousClass1 */

                    public final void run() {
                        AppMethodBeat.i(174165);
                        a.a(a.this, String.format("已加载 %d", Integer.valueOf(i3)));
                        AppMethodBeat.o(174165);
                    }
                });
                AppMethodBeat.o(174159);
            }
        });
        AppMethodBeat.o(174167);
    }

    static /* synthetic */ void a(a aVar) {
        AppMethodBeat.i(174170);
        aVar.removeView(aVar.f2384c);
        AppMethodBeat.o(174170);
    }

    static /* synthetic */ void a(a aVar, Runnable runnable) {
        AppMethodBeat.i(174169);
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
            AppMethodBeat.o(174169);
            return;
        }
        aVar.f2383b.post(runnable);
        AppMethodBeat.o(174169);
    }

    static /* synthetic */ void a(a aVar, String str) {
        AppMethodBeat.i(174168);
        Toast.makeText(aVar.getContext(), str, 0).show();
        AppMethodBeat.o(174168);
    }
}
