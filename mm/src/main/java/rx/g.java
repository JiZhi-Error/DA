package rx;

import java.util.concurrent.TimeUnit;
import rx.b.e;
import rx.internal.c.k;

public abstract class g {
    static final long UjX = TimeUnit.MINUTES.toNanos(Long.getLong("rx.scheduler.drift-tolerance", 15).longValue());

    public abstract a createWorker();

    public static abstract class a implements j {
        public abstract j a(rx.b.a aVar);

        public abstract j a(rx.b.a aVar, long j2, TimeUnit timeUnit);

        public long now() {
            return System.currentTimeMillis();
        }
    }

    public long now() {
        return System.currentTimeMillis();
    }

    public <S extends g & j> S when(e<d<d<b>>, b> eVar) {
        return new k(eVar, this);
    }
}
