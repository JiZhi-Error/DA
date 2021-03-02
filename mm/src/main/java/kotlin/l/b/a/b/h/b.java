package kotlin.l.b.a.b.h;

import com.tencent.thumbplayer.api.TPOptionalID;
import java.io.IOException;
import java.io.InputStream;
import kotlin.l.b.a.b.h.a;
import kotlin.l.b.a.b.h.q;

public abstract class b<MessageType extends q> implements s<MessageType> {
    private static final g TDn = g.hJw();

    private static MessageType a(MessageType messagetype) {
        w wVar;
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        if (messagetype instanceof a) {
            wVar = new w();
        } else {
            wVar = new w();
        }
        k kVar = new k(wVar.getMessage());
        kVar.TDK = messagetype;
        throw kVar;
    }

    private MessageType a(d dVar, g gVar) {
        try {
            e hJn = dVar.hJn();
            MessageType messagetype = (MessageType) ((q) a(hJn, gVar));
            try {
                hJn.fF(0);
                return messagetype;
            } catch (k e2) {
                e2.TDK = messagetype;
                throw e2;
            }
        } catch (k e3) {
            throw e3;
        }
    }

    private MessageType g(InputStream inputStream, g gVar) {
        e V = e.V(inputStream);
        MessageType messagetype = (MessageType) ((q) a(V, gVar));
        try {
            V.fF(0);
            return messagetype;
        } catch (k e2) {
            e2.TDK = messagetype;
            throw e2;
        }
    }

    private MessageType h(InputStream inputStream, g gVar) {
        try {
            int read = inputStream.read();
            if (read == -1) {
                return null;
            }
            if ((read & 128) != 0) {
                read &= TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH;
                int i2 = 7;
                while (true) {
                    if (i2 < 32) {
                        int read2 = inputStream.read();
                        if (read2 != -1) {
                            read |= (read2 & TPOptionalID.OPTION_ID_BEFORE_BOOL_ENABLE_AUDIO_PASSTHROUGH) << i2;
                            if ((read2 & 128) == 0) {
                                break;
                            }
                            i2 += 7;
                        } else {
                            throw k.hJD();
                        }
                    } else {
                        while (i2 < 64) {
                            int read3 = inputStream.read();
                            if (read3 == -1) {
                                throw k.hJD();
                            } else if ((read3 & 128) != 0) {
                                i2 += 7;
                            }
                        }
                        throw k.hJF();
                    }
                }
            }
            return g(new a.AbstractC2337a.C2338a(inputStream, read), gVar);
        } catch (IOException e2) {
            throw new k(e2.getMessage());
        }
    }

    @Override // kotlin.l.b.a.b.h.s
    public final /* synthetic */ Object i(InputStream inputStream, g gVar) {
        return a(h(inputStream, gVar));
    }

    @Override // kotlin.l.b.a.b.h.s
    public final /* synthetic */ Object j(InputStream inputStream, g gVar) {
        return a(g(inputStream, gVar));
    }

    @Override // kotlin.l.b.a.b.h.s
    public final /* synthetic */ Object b(d dVar, g gVar) {
        return a(a(dVar, gVar));
    }
}
