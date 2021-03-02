package com.tencent.i.a.b.b;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import com.tencent.h.a.b;
import com.tencent.h.c.h;
import com.tencent.i.a.a.c;
import com.tencent.i.a.a.e;
import com.tencent.i.a.c.d;
import com.tencent.i.a.h;
import com.tencent.i.a.k;
import com.tencent.i.a.m;
import com.tencent.midas.data.APMidasPluginInfo;

public abstract class a implements b {
    public c SqM;
    protected com.tencent.i.a.c.b Srk;

    public a(Context context, m mVar) {
        h.hpU();
        this.SqM = new c(context, mVar);
        this.SqM.SqP = this;
    }

    public final boolean hqo() {
        Throwable th;
        boolean z;
        if (this.SqM.mAppContext == null) {
            throw new k("the context is error");
        }
        try {
            Context context = this.SqM.mAppContext;
            com.tencent.i.a.a.b.b bVar = this.SqM.SqO;
            if (bVar != null) {
                int[] iArr = {1, 4, 9};
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                int i2 = 1;
                boolean z2 = true;
                for (int i3 = 0; i3 < 3; i3++) {
                    Sensor defaultSensor = sensorManager.getDefaultSensor(iArr[i3]);
                    i2 |= (defaultSensor == null ? 0 : 1) << i3;
                    if (defaultSensor == null) {
                        z2 = false;
                    }
                }
                bVar.SqX = z2;
                bVar.SqY = i2;
            }
            this.Srk = new d(this.SqM);
            new e(this.SqM, "turing_smi");
            try {
                new StringBuilder("TuringSMI V_2_24C8B65CA976DDE3_2020-12-07-06-01_301096_2-").append(this.SqM.SqO.SqX).append("-false_true_false");
                return true;
            } catch (Throwable th2) {
                th = th2;
                z = true;
                if (this.SqM == null && this.SqM.SqP != null) {
                    this.SqM.SqP.b(th, APMidasPluginInfo.LAUNCH_INTERFACE_INIT);
                    return z;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            z = false;
            return this.SqM == null ? z : z;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x013d A[Catch:{ Throwable -> 0x00ae }] */
    @Override // com.tencent.h.a.b
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(java.lang.Throwable r13, java.lang.String r14) {
        /*
        // Method dump skipped, instructions count: 430
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.i.a.b.b.a.b(java.lang.Throwable, java.lang.String):boolean");
    }

    /* access modifiers changed from: protected */
    public final boolean a(h.a aVar, com.tencent.i.a.c.a aVar2) {
        try {
            return this.Srk.b(aVar, aVar2);
        } catch (Throwable th) {
            if (this.SqM == null || this.SqM.SqP == null) {
                return false;
            }
            this.SqM.SqP.b(th, "start_ct");
            return false;
        }
    }

    public static boolean a(com.tencent.i.a.c.b.a aVar, com.tencent.i.a.b.a.a aVar2) {
        if (aVar == null || aVar2 == null || aVar2.Srg == null) {
            return false;
        }
        aVar.SrT = aVar2.Srg;
        return true;
    }
}
