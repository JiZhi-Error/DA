package com.tencent.mm.recoveryv2;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.recoveryv2.a;

public interface b {
    b a(h hVar);

    void a(Context context, RecoveryCrash recoveryCrash);

    void b(Context context, RecoveryCrash recoveryCrash);

    public static abstract class a implements b {
        protected h NBu;

        @Override // com.tencent.mm.recoveryv2.b
        public final b a(h hVar) {
            this.NBu = hVar;
            return this;
        }

        @Override // com.tencent.mm.recoveryv2.b
        public void b(Context context, RecoveryCrash recoveryCrash) {
            a.C2043a.log(4, "MicroMsg.recovery.callback", "recovery on terminate");
        }
    }

    public static class c extends a {
        private b NBv;

        @Override // com.tencent.mm.recoveryv2.b, com.tencent.mm.recoveryv2.b.a
        public final void b(Context context, RecoveryCrash recoveryCrash) {
            AppMethodBeat.i(193763);
            if (this.NBv != null) {
                this.NBv.b(context, recoveryCrash);
            }
            AppMethodBeat.o(193763);
        }

        /* access modifiers changed from: protected */
        public Class<? extends Activity> guw() {
            return null;
        }

        /* access modifiers changed from: protected */
        public Class<? extends Service> gux() {
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0074  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00ed  */
        @Override // com.tencent.mm.recoveryv2.b
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void a(android.content.Context r13, com.tencent.mm.recoveryv2.RecoveryCrash r14) {
            /*
            // Method dump skipped, instructions count: 259
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.recoveryv2.b.c.a(android.content.Context, com.tencent.mm.recoveryv2.RecoveryCrash):void");
        }
    }

    /* renamed from: com.tencent.mm.recoveryv2.b$b  reason: collision with other inner class name */
    public static class C2044b extends a {
        private boolean gSF = false;

        @Override // com.tencent.mm.recoveryv2.b
        public final void a(Context context, RecoveryCrash recoveryCrash) {
            AppMethodBeat.i(193758);
            Intent intent = new Intent();
            Class<? extends Activity> guw = guw();
            if (guw == null) {
                a.C2043a.log(4, "MicroMsg.recovery.callback", "can not get target activity, skip");
                AppMethodBeat.o(193758);
                return;
            }
            try {
                a.C2043a.log(4, "MicroMsg.recovery.callback", "start recovery activity, target = " + guw.getName());
                intent.setClass(context, guw);
                intent.putExtra("extra_crash_count", recoveryCrash.NBA.NBC);
                intent.putExtra("extra_crash_record", recoveryCrash.guD());
                intent.addFlags(276824064);
                com.tencent.mm.hellhoundlib.b.a bl = new com.tencent.mm.hellhoundlib.b.a().bl(intent);
                com.tencent.mm.hellhoundlib.a.a.a(context, bl.axQ(), "com/tencent/mm/recoveryv2/RecoveryCallback$ActivityRecoveryCallback", "onRecovery", "(Landroid/content/Context;Lcom/tencent/mm/recoveryv2/RecoveryCrash;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                context.startActivity((Intent) bl.pG(0));
                com.tencent.mm.hellhoundlib.a.a.a(context, "com/tencent/mm/recoveryv2/RecoveryCallback$ActivityRecoveryCallback", "onRecovery", "(Landroid/content/Context;Lcom/tencent/mm/recoveryv2/RecoveryCrash;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
                this.gSF = true;
                AppMethodBeat.o(193758);
            } catch (Exception e2) {
                a.w("MicroMsg.recovery.callback", "start activity fail", e2);
                AppMethodBeat.o(193758);
            }
        }

        @Override // com.tencent.mm.recoveryv2.b, com.tencent.mm.recoveryv2.b.a
        public final void b(Context context, RecoveryCrash recoveryCrash) {
            AppMethodBeat.i(193759);
            if (!this.gSF) {
                a.C2043a.log(5, "MicroMsg.recovery.callback", "do NOT suicide, bcs launching activity fail");
                AppMethodBeat.o(193759);
                return;
            }
            a.C2043a.log(4, "MicroMsg.recovery.callback", "suicide when launch recovery activity");
            if (context instanceof Activity) {
                ((Activity) context).finish();
            }
            com.tencent.mm.hellhoundlib.b.a a2 = com.tencent.mm.hellhoundlib.b.c.a(Process.myPid(), new com.tencent.mm.hellhoundlib.b.a());
            Object obj = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(obj, a2.axQ(), "com/tencent/mm/recoveryv2/Utils", "killProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            Process.killProcess(((Integer) a2.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(obj, "com/tencent/mm/recoveryv2/Utils", "killProcess", "()V", "android/os/Process_EXEC_", "killProcess", "(I)V");
            com.tencent.mm.hellhoundlib.b.a a3 = com.tencent.mm.hellhoundlib.b.c.a(0, new com.tencent.mm.hellhoundlib.b.a());
            Object obj2 = new Object();
            com.tencent.mm.hellhoundlib.a.a.a(obj2, a3.axQ(), "com/tencent/mm/recoveryv2/Utils", "killProcess", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
            System.exit(((Integer) a3.pG(0)).intValue());
            com.tencent.mm.hellhoundlib.a.a.a(obj2, "com/tencent/mm/recoveryv2/Utils", "killProcess", "()V", "java/lang/System_EXEC_", "exit", "(I)V");
            AppMethodBeat.o(193759);
        }

        /* access modifiers changed from: protected */
        public Class<? extends Activity> guw() {
            return null;
        }
    }

    public static class d extends a {
        @Override // com.tencent.mm.recoveryv2.b
        public final void a(Context context, RecoveryCrash recoveryCrash) {
            AppMethodBeat.i(193764);
            Class<? extends Service> gux = gux();
            if (gux == null) {
                a.C2043a.log(4, "MicroMsg.recovery.callback", "can not get target service, skip");
                AppMethodBeat.o(193764);
                return;
            }
            try {
                Intent intent = new Intent();
                intent.setClass(context, gux);
                intent.putExtra("extra_crash_count", recoveryCrash.NBA.NBC);
                intent.putExtra("extra_crash_record", recoveryCrash.guD());
                context.startService(intent);
                AppMethodBeat.o(193764);
            } catch (Exception e2) {
                a.w("MicroMsg.recovery.callback", "start service fail", e2);
                AppMethodBeat.o(193764);
            }
        }

        /* access modifiers changed from: protected */
        public Class<? extends Service> gux() {
            return null;
        }
    }
}
