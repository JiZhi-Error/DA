package io.flutter.plugin.platform;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tavkit.component.TAVExporter;
import io.flutter.embedding.engine.c.g;
import java.util.List;

public final class b {
    private final g SOe;
    private g.h STb;
    int STc;
    private final g.f STd = new g.f() {
        /* class io.flutter.plugin.platform.b.AnonymousClass1 */

        @Override // io.flutter.embedding.engine.c.g.f
        public final void a(g.EnumC2248g gVar) {
            AppMethodBeat.i(9905);
            b bVar = b.this;
            if (gVar == g.EnumC2248g.CLICK) {
                bVar.activity.getWindow().getDecorView().playSoundEffect(0);
            }
            AppMethodBeat.o(9905);
        }

        @Override // io.flutter.embedding.engine.c.g.f
        public final void a(g.e eVar) {
            AppMethodBeat.i(9906);
            View decorView = b.this.activity.getWindow().getDecorView();
            switch (AnonymousClass2.STf[eVar.ordinal()]) {
                case 1:
                    decorView.performHapticFeedback(0);
                    AppMethodBeat.o(9906);
                    return;
                case 2:
                    decorView.performHapticFeedback(1);
                    AppMethodBeat.o(9906);
                    return;
                case 3:
                    decorView.performHapticFeedback(3);
                    AppMethodBeat.o(9906);
                    return;
                case 4:
                    if (Build.VERSION.SDK_INT >= 23) {
                        decorView.performHapticFeedback(6);
                        AppMethodBeat.o(9906);
                        return;
                    }
                    break;
                case 5:
                    if (Build.VERSION.SDK_INT >= 21) {
                        decorView.performHapticFeedback(4);
                        break;
                    }
                    break;
            }
            AppMethodBeat.o(9906);
        }

        @Override // io.flutter.embedding.engine.c.g.f
        public final void ats(int i2) {
            AppMethodBeat.i(9907);
            b.this.activity.setRequestedOrientation(i2);
            AppMethodBeat.o(9907);
        }

        @Override // io.flutter.embedding.engine.c.g.f
        public final void a(g.a aVar) {
            AppMethodBeat.i(9908);
            b bVar = b.this;
            if (Build.VERSION.SDK_INT >= 21) {
                if (Build.VERSION.SDK_INT < 28 && Build.VERSION.SDK_INT > 21) {
                    bVar.activity.setTaskDescription(new ActivityManager.TaskDescription(aVar.label, (Bitmap) null, aVar.color));
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    bVar.activity.setTaskDescription(new ActivityManager.TaskDescription(aVar.label, 0, aVar.color));
                }
            }
            AppMethodBeat.o(9908);
        }

        @Override // io.flutter.embedding.engine.c.g.f
        public final void kn(List<g.i> list) {
            AppMethodBeat.i(9909);
            b bVar = b.this;
            int i2 = 1798;
            if (list.size() == 0 && Build.VERSION.SDK_INT >= 19) {
                i2 = 5894;
            }
            int i3 = i2;
            for (int i4 = 0; i4 < list.size(); i4++) {
                switch (AnonymousClass2.SQi[list.get(i4).ordinal()]) {
                    case 1:
                        i3 &= -5;
                        break;
                    case 2:
                        i3 = i3 & -513 & -3;
                        break;
                }
            }
            bVar.STc = i3;
            bVar.hxp();
            AppMethodBeat.o(9909);
        }

        @Override // io.flutter.embedding.engine.c.g.f
        public final void hxg() {
            AppMethodBeat.i(9910);
            b.this.hxp();
            AppMethodBeat.o(9910);
        }

        @Override // io.flutter.embedding.engine.c.g.f
        public final void a(g.h hVar) {
            AppMethodBeat.i(9911);
            b.this.b(hVar);
            AppMethodBeat.o(9911);
        }

        @Override // io.flutter.embedding.engine.c.g.f
        public final void hxh() {
            AppMethodBeat.i(9912);
            b.this.activity.finish();
            AppMethodBeat.o(9912);
        }

        @Override // io.flutter.embedding.engine.c.g.f
        public final CharSequence a(g.c cVar) {
            AppMethodBeat.i(9913);
            b bVar = b.this;
            ClipData primaryClip = ((ClipboardManager) bVar.activity.getSystemService("clipboard")).getPrimaryClip();
            if (primaryClip == null || !(cVar == null || cVar == g.c.PLAIN_TEXT)) {
                AppMethodBeat.o(9913);
                return null;
            }
            CharSequence coerceToText = primaryClip.getItemAt(0).coerceToText(bVar.activity);
            AppMethodBeat.o(9913);
            return coerceToText;
        }

        @Override // io.flutter.embedding.engine.c.g.f
        public final void btl(String str) {
            AppMethodBeat.i(9914);
            ((ClipboardManager) b.this.activity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text label?", str));
            AppMethodBeat.o(9914);
        }
    };
    final Activity activity;

    public b(Activity activity2, g gVar) {
        AppMethodBeat.i(9883);
        this.activity = activity2;
        this.SOe = gVar;
        this.SOe.SQf = this.STd;
        this.STc = TAVExporter.VIDEO_EXPORT_HEIGHT;
        AppMethodBeat.o(9883);
    }

    public final void destroy() {
        this.SOe.SQf = null;
    }

    public final void hxp() {
        AppMethodBeat.i(9884);
        this.activity.getWindow().getDecorView().setSystemUiVisibility(this.STc);
        if (this.STb != null) {
            b(this.STb);
        }
        AppMethodBeat.o(9884);
    }

    /* access modifiers changed from: package-private */
    public final void b(g.h hVar) {
        AppMethodBeat.i(9885);
        Window window = this.activity.getWindow();
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        if (Build.VERSION.SDK_INT >= 26) {
            if (hVar.SQF != null) {
                switch (hVar.SQF) {
                    case DARK:
                        systemUiVisibility |= 16;
                        break;
                    case LIGHT:
                        systemUiVisibility &= -17;
                        break;
                }
            }
            if (hVar.SQE != null) {
                window.setNavigationBarColor(hVar.SQE.intValue());
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (hVar.SQD != null) {
                switch (hVar.SQD) {
                    case DARK:
                        systemUiVisibility |= 8192;
                        break;
                    case LIGHT:
                        systemUiVisibility &= -8193;
                        break;
                }
            }
            if (hVar.SQC != null) {
                window.setStatusBarColor(hVar.SQC.intValue());
            }
        }
        decorView.setSystemUiVisibility(systemUiVisibility);
        this.STb = hVar;
        AppMethodBeat.o(9885);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: io.flutter.plugin.platform.b$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] SQi = new int[g.i.values().length];
        static final /* synthetic */ int[] STf = new int[g.e.values().length];

        static {
            AppMethodBeat.i(9889);
            STg = new int[g.b.values().length];
            try {
                STg[g.b.DARK.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                STg[g.b.LIGHT.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                SQi[g.i.TOP_OVERLAYS.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                SQi[g.i.BOTTOM_OVERLAYS.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                STf[g.e.STANDARD.ordinal()] = 1;
            } catch (NoSuchFieldError e6) {
            }
            try {
                STf[g.e.LIGHT_IMPACT.ordinal()] = 2;
            } catch (NoSuchFieldError e7) {
            }
            try {
                STf[g.e.MEDIUM_IMPACT.ordinal()] = 3;
            } catch (NoSuchFieldError e8) {
            }
            try {
                STf[g.e.HEAVY_IMPACT.ordinal()] = 4;
            } catch (NoSuchFieldError e9) {
            }
            try {
                STf[g.e.SELECTION_CLICK.ordinal()] = 5;
                AppMethodBeat.o(9889);
            } catch (NoSuchFieldError e10) {
                AppMethodBeat.o(9889);
            }
        }
    }
}
