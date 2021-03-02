package com.tencent.mm.app;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public interface o {
    void onAppBackground(String str);

    void onAppForeground(String str);

    public static abstract class a implements o {
        o wrapper = new o() {
            /* class com.tencent.mm.app.o.a.AnonymousClass1 */

            @Override // com.tencent.mm.app.o
            public final void onAppForeground(final String str) {
                AppMethodBeat.i(131785);
                if (a.this.getHandler() != null) {
                    a.this.getHandler().post(new Runnable() {
                        /* class com.tencent.mm.app.o.a.AnonymousClass1.AnonymousClass1 */

                        public final void run() {
                            AppMethodBeat.i(131783);
                            a.this.onAppForeground(str);
                            AppMethodBeat.o(131783);
                        }
                    });
                    AppMethodBeat.o(131785);
                    return;
                }
                a.this.onAppForeground(str);
                AppMethodBeat.o(131785);
            }

            @Override // com.tencent.mm.app.o
            public final void onAppBackground(final String str) {
                AppMethodBeat.i(131786);
                if (a.this.getHandler() != null) {
                    a.this.getHandler().post(new Runnable() {
                        /* class com.tencent.mm.app.o.a.AnonymousClass1.AnonymousClass2 */

                        public final void run() {
                            AppMethodBeat.i(131784);
                            a.this.onAppBackground(str);
                            AppMethodBeat.o(131784);
                        }
                    });
                    AppMethodBeat.o(131786);
                    return;
                }
                a.this.onAppBackground(str);
                AppMethodBeat.o(131786);
            }
        };

        public void alive() {
            AppForegroundDelegate.INSTANCE.a(this.wrapper);
        }

        public void dead() {
            AppForegroundDelegate.INSTANCE.b(this.wrapper);
        }

        /* access modifiers changed from: package-private */
        public Handler getHandler() {
            return null;
        }
    }
}
