package com.tencent.matrix.resource.b;

import android.content.Intent;
import com.tencent.c.a.a;
import java.util.concurrent.TimeUnit;

public final class a {
    private static final long cYA = TimeUnit.MINUTES.toMillis(1);
    public static final long cYB = TimeUnit.MINUTES.toMillis(20);
    private static final b cYC = b.MANUAL_DUMP;
    public final com.tencent.c.a.a cQF;
    public final b cYD;
    public final boolean cYE;
    public final Intent cYF;

    /* renamed from: com.tencent.matrix.resource.b.a$a  reason: collision with other inner class name */
    public static final class C0229a {
        public com.tencent.c.a.a cVx;
        public boolean cYE = false;
        public Intent cYF;
        public b cYG = a.cYC;
    }

    public enum b {
        NO_DUMP,
        AUTO_DUMP,
        MANUAL_DUMP,
        SILENCE_DUMP
    }

    public /* synthetic */ a(com.tencent.c.a.a aVar, b bVar, boolean z, Intent intent, byte b2) {
        this(aVar, bVar, z, intent);
    }

    private a(com.tencent.c.a.a aVar, b bVar, boolean z, Intent intent) {
        this.cQF = aVar;
        this.cYD = bVar;
        this.cYE = z;
        this.cYF = intent;
    }

    public final long Tb() {
        return this.cQF.get(a.EnumC0131a.clicfg_matrix_resource_detect_interval_millis.name(), cYA);
    }
}
