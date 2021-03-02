package com.tencent.toybrick.e;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.as;
import com.tencent.toybrick.c.f;
import java.lang.ref.WeakReference;

public final class c {
    public static volatile c Sox = new c();
    private Handler mMainHandler = new Handler(Looper.getMainLooper()) {
        /* class com.tencent.toybrick.e.c.AnonymousClass1 */

        public final void handleMessage(Message message) {
            AppMethodBeat.i(159971);
            super.handleMessage(message);
            if (message.what == 2) {
                RunnableC2223c cVar = (RunnableC2223c) message.obj;
                com.tencent.toybrick.f.a aVar = (com.tencent.toybrick.f.a) cVar.SoA.get();
                if (aVar == null || aVar.SoF.hashCode() != cVar.key) {
                    as.w("WhenHandler", "[WhenHandler] has loaded! but not right,holder has changed!", new Object[0]);
                    AppMethodBeat.o(159971);
                    return;
                }
                cVar.SoC.T(aVar, cVar.object);
                AppMethodBeat.o(159971);
                return;
            }
            if (message.what == 3) {
                d dVar = (d) message.obj;
                dVar.SoE.g(dVar.SoD.get(), ((Boolean) dVar.object).booleanValue());
            }
            AppMethodBeat.o(159971);
        }
    };

    public interface a<H, T> {
        void T(H h2, T t);
    }

    public interface b<T> {
        void g(T t, boolean z);
    }

    static {
        AppMethodBeat.i(159981);
        AppMethodBeat.o(159981);
    }

    private c() {
        AppMethodBeat.i(159977);
        AppMethodBeat.o(159977);
    }

    public final void a(com.tencent.toybrick.f.a aVar, com.tencent.toybrick.g.b bVar, a aVar2) {
        AppMethodBeat.i(159978);
        a.hpK().execute(new RunnableC2223c(aVar, bVar, aVar2, aVar.SoF.hashCode()));
        AppMethodBeat.o(159978);
    }

    public final void a(com.tencent.toybrick.f.a aVar, com.tencent.toybrick.g.b bVar, ImageView imageView) {
        AppMethodBeat.i(159979);
        final WeakReference weakReference = new WeakReference(imageView);
        a.hpK().execute(new RunnableC2223c(aVar, bVar, new a<com.tencent.toybrick.f.a, Drawable>() {
            /* class com.tencent.toybrick.e.c.AnonymousClass2 */

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
            @Override // com.tencent.toybrick.e.c.a
            public final /* synthetic */ void T(com.tencent.toybrick.f.a aVar, Drawable drawable) {
                AppMethodBeat.i(159972);
                Drawable drawable2 = drawable;
                if (drawable2 != null) {
                    ImageView imageView = (ImageView) weakReference.get();
                    if (imageView != null) {
                        imageView.setVisibility(0);
                        imageView.setImageDrawable(drawable2);
                    }
                    AppMethodBeat.o(159972);
                    return;
                }
                ImageView imageView2 = (ImageView) weakReference.get();
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                }
                AppMethodBeat.o(159972);
            }
        }, aVar.SoF.hashCode()));
        AppMethodBeat.o(159979);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.tencent.toybrick.e.c$c  reason: collision with other inner class name */
    public class RunnableC2223c implements Runnable {
        private WeakReference<com.tencent.toybrick.f.a> SoA;
        private WeakReference<com.tencent.toybrick.g.b> SoB;
        private a SoC;
        private int key;
        private Object object;

        public RunnableC2223c(com.tencent.toybrick.f.a aVar, com.tencent.toybrick.g.b bVar, a aVar2, int i2) {
            AppMethodBeat.i(159973);
            this.SoA = new WeakReference<>(aVar);
            this.SoB = new WeakReference<>(bVar);
            this.SoC = aVar2;
            this.key = i2;
            AppMethodBeat.o(159973);
        }

        public final void run() {
            AppMethodBeat.i(159974);
            com.tencent.toybrick.f.a aVar = this.SoA.get();
            com.tencent.toybrick.g.b bVar = this.SoB.get();
            if (!(aVar == null || bVar == null)) {
                this.object = bVar.hpL();
                Message message = new Message();
                message.what = 2;
                message.obj = this;
                c.this.mMainHandler.sendMessage(message);
            }
            AppMethodBeat.o(159974);
        }
    }

    public class d implements Runnable {
        private WeakReference<com.tencent.toybrick.g.b> SoB;
        private WeakReference<f> SoD;
        private b SoE;
        private Object object;

        public d(f fVar, com.tencent.toybrick.g.b bVar, b bVar2) {
            AppMethodBeat.i(159975);
            this.SoD = new WeakReference<>(fVar);
            this.SoB = new WeakReference<>(bVar);
            this.SoE = bVar2;
            AppMethodBeat.o(159975);
        }

        public final void run() {
            AppMethodBeat.i(159976);
            com.tencent.toybrick.g.b bVar = this.SoB.get();
            f fVar = this.SoD.get();
            if (!(bVar == null || fVar == null)) {
                this.object = bVar.hpL();
                Message message = new Message();
                message.what = 3;
                message.obj = this;
                c.this.mMainHandler.sendMessage(message);
            }
            AppMethodBeat.o(159976);
        }
    }

    public static void execute(Runnable runnable) {
        AppMethodBeat.i(258273);
        a.hpK().execute(runnable);
        AppMethodBeat.o(258273);
    }
}
