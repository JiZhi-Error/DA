package kotlin.n;

import com.facebook.internal.FacebookRequestErrorClassification;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.midas.comm.log.util.APLogFileUtil;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.a.e;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.k.d;
import kotlin.k.f;
import kotlin.k.j;
import kotlin.l;
import kotlin.m.h;
import kotlin.m.i;
import kotlin.o;
import kotlin.s;

@l(hxD = {1, 1, 16}, hxE = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0019\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\u001a\u001c\u0010\t\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u000e\u001a\u00020\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001a\u001f\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0002\u001a\u0015\u0010\u000f\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\n\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010\u0014\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a:\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001aE\u0010\u0016\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b\u001c\u001a:\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010\u001e\u001a\u00020\r*\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u0006\u001a4\u0010 \u001a\u0002H!\"\f\b\u0000\u0010\"*\u00020\u0002*\u0002H!\"\u0004\b\u0001\u0010!*\u0002H\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\b¢\u0006\u0002\u0010%\u001a4\u0010&\u001a\u0002H!\"\f\b\u0000\u0010\"*\u00020\u0002*\u0002H!\"\u0004\b\u0001\u0010!*\u0002H\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H!0$H\b¢\u0006\u0002\u0010%\u001a&\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a;\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u001b\u001a\u00020\rH\u0002¢\u0006\u0002\b)\u001a&\u0010'\u001a\u00020\u0006*\u00020\u00022\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u0010+\u001a\u00020\u0006*\u00020\u00022\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u0010+\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\r\u0010.\u001a\u00020\r*\u00020\u0002H\b\u001a\r\u0010/\u001a\u00020\r*\u00020\u0002H\b\u001a\r\u00100\u001a\u00020\r*\u00020\u0002H\b\u001a \u00101\u001a\u00020\r*\u0004\u0018\u00010\u0002H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a \u00102\u001a\u00020\r*\u0004\u0018\u00010\u0002H\b\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000\u001a\r\u00103\u001a\u000204*\u00020\u0002H\u0002\u001a&\u00105\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u00105\u001a\u00020\u0006*\u00020\u00022\u0006\u0010*\u001a\u00020\n2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a&\u00106\u001a\u00020\u0006*\u00020\u00022\u0006\u0010,\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a,\u00106\u001a\u00020\u0006*\u00020\u00022\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0010\u00107\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u0002\u001a\u0010\u00109\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u0002\u001a\u0015\u0010;\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\f\u001a\u000f\u0010<\u001a\u00020\n*\u0004\u0018\u00010\nH\b\u001a\u001c\u0010=\u001a\u00020\u0002*\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010=\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010@\u001a\u00020\u0002*\u00020\u00022\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001a\u001c\u0010@\u001a\u00020\n*\u00020\n2\u0006\u0010>\u001a\u00020\u00062\b\b\u0002\u0010?\u001a\u00020\u0011\u001aG\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000108*\u00020\u00022\u000e\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0004\bE\u0010F\u001a=\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000108*\u00020\u00022\u0006\u0010B\u001a\u00020-2\b\b\u0002\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0002\bE\u001a4\u0010G\u001a\u00020\r*\u00020\u00022\u0006\u0010H\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00022\u0006\u0010I\u001a\u00020\u00062\u0006\u0010>\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0000\u001a\u0012\u0010J\u001a\u00020\u0002*\u00020\u00022\u0006\u0010K\u001a\u00020\u0002\u001a\u0012\u0010J\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\u0002\u001a\u001a\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006\u001a\u0012\u0010L\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u001d\u0010L\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\b\u001a\u0015\u0010L\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u0001H\b\u001a\u0012\u0010N\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010N\u001a\u00020\n*\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\u0002*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a\u0012\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u0002\u001a\u001a\u0010O\u001a\u00020\n*\u00020\n2\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0002\u001a+\u0010Q\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0014\b\b\u0010R\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\u00020SH\b\u001a\u001d\u0010Q\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\nH\b\u001a$\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010V\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010X\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010X\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Y\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Y\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Z\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a$\u0010Z\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\u0006\u0010U\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001d\u0010[\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010U\u001a\u00020\nH\b\u001a\"\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0002\u001a\u001a\u0010\\\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u0002\u001a%\u0010\\\u001a\u00020\n*\u00020\n2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u00062\u0006\u0010U\u001a\u00020\u0002H\b\u001a\u001d\u0010\\\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u00012\u0006\u0010U\u001a\u00020\u0002H\b\u001a=\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006¢\u0006\u0002\u0010^\u001a0\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\n\u0010B\u001a\u00020-\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006\u001a/\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0006\u0010P\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010D\u001a\u00020\u0006H\u0002¢\u0006\u0002\b_\u001a%\u0010]\u001a\b\u0012\u0004\u0012\u00020\n0:*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010D\u001a\u00020\u0006H\b\u001a=\u0010`\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u00022\u0012\u0010B\u001a\n\u0012\u0006\b\u0001\u0012\u00020\n0C\"\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006¢\u0006\u0002\u0010a\u001a0\u0010`\u001a\b\u0012\u0004\u0012\u00020\n08*\u00020\u00022\n\u0010B\u001a\u00020-\"\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010D\u001a\u00020\u0006\u001a\u001c\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u001c\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\r\u001a$\u0010b\u001a\u00020\r*\u00020\u00022\u0006\u0010K\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\r\u001a\u0012\u0010c\u001a\u00020\u0002*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u001d\u0010c\u001a\u00020\u0002*\u00020\n2\u0006\u0010d\u001a\u00020\u00062\u0006\u0010e\u001a\u00020\u0006H\b\u001a\u001f\u0010f\u001a\u00020\n*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020\u0006H\b\u001a\u0012\u0010f\u001a\u00020\n*\u00020\u00022\u0006\u0010M\u001a\u00020\u0001\u001a\u0012\u0010f\u001a\u00020\n*\u00020\n2\u0006\u0010M\u001a\u00020\u0001\u001a\u001c\u0010g\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010g\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010h\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010h\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010i\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010i\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010j\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\u00112\b\b\u0002\u0010W\u001a\u00020\n\u001a\u001c\u0010j\u001a\u00020\n*\u00020\n2\u0006\u0010P\u001a\u00020\n2\b\b\u0002\u0010W\u001a\u00020\n\u001a\n\u0010k\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010k\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010k\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010k\u001a\u00020\n*\u00020\nH\b\u001a!\u0010k\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010k\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\n\u0010m\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010m\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010m\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010m\u001a\u00020\n*\u00020\nH\b\u001a!\u0010m\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010m\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\n\u0010n\u001a\u00020\u0002*\u00020\u0002\u001a!\u0010n\u001a\u00020\u0002*\u00020\u00022\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010n\u001a\u00020\u0002*\u00020\u00022\n\u0010,\u001a\u00020-\"\u00020\u0011\u001a\r\u0010n\u001a\u00020\n*\u00020\nH\b\u001a!\u0010n\u001a\u00020\n*\u00020\n2\u0012\u0010l\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\r0SH\b\u001a\u0016\u0010n\u001a\u00020\n*\u00020\n2\n\u0010,\u001a\u00020-\"\u00020\u0011\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006o"}, hxF = {"indices", "Lkotlin/ranges/IntRange;", "", "getIndices", "(Ljava/lang/CharSequence;)Lkotlin/ranges/IntRange;", "lastIndex", "", "getLastIndex", "(Ljava/lang/CharSequence;)I", "commonPrefixWith", "", FacebookRequestErrorClassification.KEY_OTHER, "ignoreCase", "", "commonSuffixWith", "contains", "char", "", "regex", "Lkotlin/text/Regex;", "endsWith", "suffix", "findAnyOf", "Lkotlin/Pair;", "strings", "", "startIndex", "last", "findAnyOf$StringsKt__StringsKt", "findLastAnyOf", "hasSurrogatePairAt", FirebaseAnalytics.b.INDEX, "ifBlank", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ifEmpty", "indexOf", "endIndex", "indexOf$StringsKt__StringsKt", "string", "indexOfAny", "chars", "", "isEmpty", "isNotBlank", "isNotEmpty", "isNullOrBlank", "isNullOrEmpty", "iterator", "Lkotlin/collections/CharIterator;", "lastIndexOf", "lastIndexOfAny", "lineSequence", "Lkotlin/sequences/Sequence;", "lines", "", "matches", "orEmpty", "padEnd", "length", "padChar", "padStart", "rangesDelimitedBy", "delimiters", "", "limit", "rangesDelimitedBy$StringsKt__StringsKt", "(Ljava/lang/CharSequence;[Ljava/lang/String;IZI)Lkotlin/sequences/Sequence;", "regionMatchesImpl", "thisOffset", "otherOffset", "removePrefix", "prefix", "removeRange", "range", "removeSuffix", "removeSurrounding", "delimiter", "replace", "transform", "Lkotlin/Function1;", "Lkotlin/text/MatchResult;", "replacement", "replaceAfter", "missingDelimiterValue", "replaceAfterLast", "replaceBefore", "replaceBeforeLast", "replaceFirst", "replaceRange", "split", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Ljava/util/List;", "split$StringsKt__StringsKt", "splitToSequence", "(Ljava/lang/CharSequence;[Ljava/lang/String;ZI)Lkotlin/sequences/Sequence;", "startsWith", "subSequence", "start", "end", "substring", "substringAfter", "substringAfterLast", "substringBefore", "substringBeforeLast", "trim", "predicate", "trimEnd", "trimStart", "kotlin-stdlib"}, hxG = 1)
public class x extends w {
    public static final f aN(CharSequence charSequence) {
        AppMethodBeat.i(129378);
        p.h(charSequence, "$this$indices");
        f fVar = new f(0, charSequence.length() - 1);
        AppMethodBeat.o(129378);
        return fVar;
    }

    public static final int aO(CharSequence charSequence) {
        AppMethodBeat.i(129379);
        p.h(charSequence, "$this$lastIndex");
        int length = charSequence.length() - 1;
        AppMethodBeat.o(129379);
        return length;
    }

    public static /* synthetic */ String a(String str, char c2) {
        AppMethodBeat.i(206235);
        String a2 = n.a(str, c2, str);
        AppMethodBeat.o(206235);
        return a2;
    }

    public static final String a(String str, char c2, String str2) {
        AppMethodBeat.i(206234);
        p.h(str, "$this$substringBefore");
        p.h(str2, "missingDelimiterValue");
        int a2 = n.a((CharSequence) str, c2, 0, false, 6);
        if (a2 == -1) {
            AppMethodBeat.o(206234);
            return str2;
        }
        String substring = str.substring(0, a2);
        p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.o(206234);
        return substring;
    }

    public static /* synthetic */ String oz(String str, String str2) {
        AppMethodBeat.i(129383);
        String bz = n.bz(str, str2, str);
        AppMethodBeat.o(129383);
        return bz;
    }

    public static final String bz(String str, String str2, String str3) {
        AppMethodBeat.i(129382);
        p.h(str, "$this$substringBefore");
        p.h(str2, "delimiter");
        p.h(str3, "missingDelimiterValue");
        int a2 = n.a((CharSequence) str, str2, 0, false, 6);
        if (a2 == -1) {
            AppMethodBeat.o(129382);
            return str3;
        }
        String substring = str.substring(0, a2);
        p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.o(129382);
        return substring;
    }

    public static final String oA(String str, String str2) {
        AppMethodBeat.i(206236);
        p.h(str, "$this$substringAfter");
        p.h(str2, "missingDelimiterValue");
        int a2 = n.a((CharSequence) str, '$', 0, false, 6);
        if (a2 == -1) {
            AppMethodBeat.o(206236);
            return str2;
        }
        String substring = str.substring(a2 + 1, str.length());
        p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.o(206236);
        return substring;
    }

    public static /* synthetic */ String oB(String str, String str2) {
        AppMethodBeat.i(129385);
        String bA = n.bA(str, str2, str);
        AppMethodBeat.o(129385);
        return bA;
    }

    public static final String bA(String str, String str2, String str3) {
        AppMethodBeat.i(129384);
        p.h(str, "$this$substringAfter");
        p.h(str2, "delimiter");
        p.h(str3, "missingDelimiterValue");
        int a2 = n.a((CharSequence) str, str2, 0, false, 6);
        if (a2 == -1) {
            AppMethodBeat.o(129384);
            return str3;
        }
        String substring = str.substring(a2 + str2.length(), str.length());
        p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.o(129384);
        return substring;
    }

    public static final String oC(String str, String str2) {
        AppMethodBeat.i(129386);
        p.h(str, "$this$substringBeforeLast");
        p.h(str2, "missingDelimiterValue");
        int b2 = n.b((CharSequence) str, '/');
        if (b2 == -1) {
            AppMethodBeat.o(129386);
            return str2;
        }
        String substring = str.substring(0, b2);
        p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.o(129386);
        return substring;
    }

    public static /* synthetic */ String b(String str, char c2) {
        AppMethodBeat.i(129388);
        String b2 = n.b(str, c2, str);
        AppMethodBeat.o(129388);
        return b2;
    }

    public static final String b(String str, char c2, String str2) {
        AppMethodBeat.i(129387);
        p.h(str, "$this$substringAfterLast");
        p.h(str2, "missingDelimiterValue");
        int b2 = n.b((CharSequence) str, c2);
        if (b2 == -1) {
            AppMethodBeat.o(129387);
            return str2;
        }
        String substring = str.substring(b2 + 1, str.length());
        p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.o(129387);
        return substring;
    }

    public static /* synthetic */ String oD(String str, String str2) {
        AppMethodBeat.i(129390);
        String bB = n.bB(str, str2, str);
        AppMethodBeat.o(129390);
        return bB;
    }

    public static final String bB(String str, String str2, String str3) {
        AppMethodBeat.i(129389);
        p.h(str, "$this$substringAfterLast");
        p.h(str2, "delimiter");
        p.h(str3, "missingDelimiterValue");
        int g2 = n.g(str, str2);
        if (g2 == -1) {
            AppMethodBeat.o(129389);
            return str3;
        }
        String substring = str.substring(g2 + str2.length(), str.length());
        p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        AppMethodBeat.o(129389);
        return substring;
    }

    public static final CharSequence a(CharSequence charSequence, int i2, int i3, CharSequence charSequence2) {
        AppMethodBeat.i(129391);
        p.h(charSequence, "$this$replaceRange");
        p.h(charSequence2, "replacement");
        if (i3 < i2) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException("End index (" + i3 + ") is less than start index (" + i2 + ").");
            AppMethodBeat.o(129391);
            throw indexOutOfBoundsException;
        }
        StringBuilder sb = new StringBuilder();
        p.g(sb.append(charSequence, 0, i2), "this.append(value, startIndex, endIndex)");
        sb.append(charSequence2);
        p.g(sb.append(charSequence, i3, charSequence.length()), "this.append(value, startIndex, endIndex)");
        StringBuilder sb2 = sb;
        AppMethodBeat.o(129391);
        return sb2;
    }

    public static final String b(String str, CharSequence charSequence) {
        AppMethodBeat.i(129392);
        p.h(str, "$this$removePrefix");
        p.h(charSequence, "prefix");
        if (n.c((CharSequence) str, charSequence)) {
            String substring = str.substring(charSequence.length());
            p.g(substring, "(this as java.lang.String).substring(startIndex)");
            AppMethodBeat.o(129392);
            return substring;
        }
        AppMethodBeat.o(129392);
        return str;
    }

    public static final String c(String str, CharSequence charSequence) {
        AppMethodBeat.i(206237);
        p.h(str, "$this$removeSuffix");
        p.h(charSequence, "suffix");
        if (n.d(str, charSequence)) {
            String substring = str.substring(0, str.length() - charSequence.length());
            p.g(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            AppMethodBeat.o(206237);
            return substring;
        }
        AppMethodBeat.o(206237);
        return str;
    }

    public static final boolean a(CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4, boolean z) {
        AppMethodBeat.i(206238);
        p.h(charSequence, "$this$regionMatchesImpl");
        p.h(charSequence2, FacebookRequestErrorClassification.KEY_OTHER);
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > charSequence2.length() - i4) {
            AppMethodBeat.o(206238);
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!a.a(charSequence.charAt(i2 + i5), charSequence2.charAt(i3 + i5), z)) {
                AppMethodBeat.o(206238);
                return false;
            }
        }
        AppMethodBeat.o(206238);
        return true;
    }

    public static final boolean aP(CharSequence charSequence) {
        AppMethodBeat.i(129394);
        p.h(charSequence, "$this$startsWith");
        if (charSequence.length() <= 0 || !a.a(charSequence.charAt(0), '0', false)) {
            AppMethodBeat.o(129394);
            return false;
        }
        AppMethodBeat.o(129394);
        return true;
    }

    public static final boolean a(CharSequence charSequence, char c2) {
        AppMethodBeat.i(129395);
        p.h(charSequence, "$this$endsWith");
        if (charSequence.length() <= 0 || !a.a(charSequence.charAt(n.aO(charSequence)), c2, false)) {
            AppMethodBeat.o(129395);
            return false;
        }
        AppMethodBeat.o(129395);
        return true;
    }

    public static final boolean c(CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.i(129396);
        p.h(charSequence, "$this$startsWith");
        p.h(charSequence2, "prefix");
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            boolean a2 = n.a(charSequence, 0, charSequence2, 0, charSequence2.length(), false);
            AppMethodBeat.o(129396);
            return a2;
        }
        boolean J = n.J((String) charSequence, (String) charSequence2, false);
        AppMethodBeat.o(129396);
        return J;
    }

    public static final boolean d(CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.i(206239);
        p.h(charSequence, "$this$endsWith");
        p.h(charSequence2, "suffix");
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            boolean a2 = n.a(charSequence, charSequence.length() - charSequence2.length(), charSequence2, 0, charSequence2.length(), false);
            AppMethodBeat.o(206239);
            return a2;
        }
        boolean nm = n.nm((String) charSequence, (String) charSequence2);
        AppMethodBeat.o(206239);
        return nm;
    }

    public static final int a(CharSequence charSequence, char[] cArr, int i2, boolean z) {
        boolean z2;
        AppMethodBeat.i(168698);
        p.h(charSequence, "$this$indexOfAny");
        p.h(cArr, "chars");
        if (z || cArr.length != 1 || !(charSequence instanceof String)) {
            int mZ = j.mZ(i2, 0);
            int aO = n.aO(charSequence);
            if (mZ <= aO) {
                while (true) {
                    char charAt = charSequence.charAt(mZ);
                    int length = cArr.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            z2 = false;
                            break;
                        } else if (a.a(cArr[i3], charAt, z)) {
                            z2 = true;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (!z2) {
                        if (mZ == aO) {
                            break;
                        }
                        mZ++;
                    } else {
                        AppMethodBeat.o(168698);
                        return mZ;
                    }
                }
            }
            AppMethodBeat.o(168698);
            return -1;
        }
        int indexOf = ((String) charSequence).indexOf(e.c(cArr), i2);
        AppMethodBeat.o(168698);
        return indexOf;
    }

    private static /* synthetic */ int a(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z) {
        AppMethodBeat.i(129399);
        int a2 = a(charSequence, charSequence2, i2, i3, z, false);
        AppMethodBeat.o(129399);
        return a2;
    }

    private static final int a(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z, boolean z2) {
        f bg;
        AppMethodBeat.i(129398);
        if (!z2) {
            bg = new f(j.mZ(i2, 0), j.na(i3, charSequence.length()));
        } else {
            int na = j.na(i2, n.aO(charSequence));
            int mZ = j.mZ(i3, 0);
            d.a aVar = d.SYW;
            bg = d.a.bg(na, mZ, -1);
        }
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int i4 = bg.SYU;
            int i5 = bg.SYV;
            int i6 = bg.lCq;
            if (i6 < 0 ? i4 >= i5 : i4 <= i5) {
                while (!n.a(charSequence2, 0, charSequence, i4, charSequence2.length(), z)) {
                    if (i4 != i5) {
                        i4 += i6;
                    }
                }
                AppMethodBeat.o(129398);
                return i4;
            }
        } else {
            int i7 = bg.SYU;
            int i8 = bg.SYV;
            int i9 = bg.lCq;
            if (i9 < 0 ? i7 >= i8 : i7 <= i8) {
                while (!n.a((String) charSequence2, 0, (String) charSequence, i7, charSequence2.length(), z)) {
                    if (i7 != i8) {
                        i7 += i9;
                    }
                }
                AppMethodBeat.o(129398);
                return i7;
            }
        }
        AppMethodBeat.o(129398);
        return -1;
    }

    public static /* synthetic */ int a(CharSequence charSequence, char c2, int i2, boolean z, int i3) {
        AppMethodBeat.i(206241);
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        int a2 = n.a(charSequence, c2, i2, false);
        AppMethodBeat.o(206241);
        return a2;
    }

    public static final int a(CharSequence charSequence, char c2, int i2, boolean z) {
        AppMethodBeat.i(206240);
        p.h(charSequence, "$this$indexOf");
        if (z || !(charSequence instanceof String)) {
            int a2 = n.a(charSequence, new char[]{c2}, i2, z);
            AppMethodBeat.o(206240);
            return a2;
        }
        int indexOf = ((String) charSequence).indexOf(c2, i2);
        AppMethodBeat.o(206240);
        return indexOf;
    }

    public static /* synthetic */ int a(CharSequence charSequence, String str, int i2, boolean z, int i3) {
        AppMethodBeat.i(129403);
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z = false;
        }
        int a2 = n.a(charSequence, str, i2, z);
        AppMethodBeat.o(129403);
        return a2;
    }

    public static final int a(CharSequence charSequence, String str, int i2, boolean z) {
        AppMethodBeat.i(129402);
        p.h(charSequence, "$this$indexOf");
        p.h(str, "string");
        if (z || !(charSequence instanceof String)) {
            int a2 = a(charSequence, str, i2, charSequence.length(), z);
            AppMethodBeat.o(129402);
            return a2;
        }
        int indexOf = ((String) charSequence).indexOf(str, i2);
        AppMethodBeat.o(129402);
        return indexOf;
    }

    public static /* synthetic */ int b(CharSequence charSequence, char c2) {
        AppMethodBeat.i(129405);
        int a2 = n.a(charSequence, c2, n.aO(charSequence));
        AppMethodBeat.o(129405);
        return a2;
    }

    public static final int a(CharSequence charSequence, char c2, int i2) {
        boolean z;
        AppMethodBeat.i(129404);
        p.h(charSequence, "$this$lastIndexOf");
        if (!(charSequence instanceof String)) {
            char[] cArr = {c2};
            p.h(charSequence, "$this$lastIndexOfAny");
            p.h(cArr, "chars");
            if (charSequence instanceof String) {
                int lastIndexOf = ((String) charSequence).lastIndexOf(e.c(cArr), i2);
                AppMethodBeat.o(129404);
                return lastIndexOf;
            }
            for (int na = j.na(i2, n.aO(charSequence)); na >= 0; na--) {
                char charAt = charSequence.charAt(na);
                int i3 = 0;
                while (true) {
                    if (i3 > 0) {
                        z = false;
                        break;
                    } else if (a.a(cArr[i3], charAt, false)) {
                        z = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z) {
                    AppMethodBeat.o(129404);
                    return na;
                }
            }
            AppMethodBeat.o(129404);
            return -1;
        }
        int lastIndexOf2 = ((String) charSequence).lastIndexOf(c2, i2);
        AppMethodBeat.o(129404);
        return lastIndexOf2;
    }

    public static /* synthetic */ int g(CharSequence charSequence, String str) {
        AppMethodBeat.i(129407);
        int a2 = n.a(charSequence, str, n.aO(charSequence));
        AppMethodBeat.o(129407);
        return a2;
    }

    public static final int a(CharSequence charSequence, String str, int i2) {
        AppMethodBeat.i(129406);
        p.h(charSequence, "$this$lastIndexOf");
        p.h(str, "string");
        if (!(charSequence instanceof String)) {
            int a2 = a(charSequence, (CharSequence) str, i2, 0, false, true);
            AppMethodBeat.o(129406);
            return a2;
        }
        int lastIndexOf = ((String) charSequence).lastIndexOf(str, i2);
        AppMethodBeat.o(129406);
        return lastIndexOf;
    }

    public static /* synthetic */ boolean e(CharSequence charSequence, CharSequence charSequence2) {
        AppMethodBeat.i(259497);
        boolean a2 = n.a(charSequence, charSequence2, false);
        AppMethodBeat.o(259497);
        return a2;
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z) {
        AppMethodBeat.i(129408);
        p.h(charSequence, "$this$contains");
        p.h(charSequence2, FacebookRequestErrorClassification.KEY_OTHER);
        if (charSequence2 instanceof String) {
            if (n.a(charSequence, (String) charSequence2, 0, z, 2) >= 0) {
                AppMethodBeat.o(129408);
                return true;
            }
            AppMethodBeat.o(129408);
            return false;
        } else if (a(charSequence, charSequence2, 0, charSequence.length(), z) >= 0) {
            AppMethodBeat.o(129408);
            return true;
        } else {
            AppMethodBeat.o(129408);
            return false;
        }
    }

    public static /* synthetic */ boolean d(CharSequence charSequence, char c2) {
        AppMethodBeat.i(129411);
        boolean c3 = n.c(charSequence, c2);
        AppMethodBeat.o(129411);
        return c3;
    }

    public static final boolean c(CharSequence charSequence, char c2) {
        AppMethodBeat.i(129410);
        p.h(charSequence, "$this$contains");
        if (n.a(charSequence, c2, 0, false, 2) >= 0) {
            AppMethodBeat.o(129410);
            return true;
        }
        AppMethodBeat.o(129410);
        return false;
    }

    public static /* synthetic */ h b(CharSequence charSequence, String[] strArr, boolean z, int i2) {
        AppMethodBeat.i(129414);
        if ((i2 & 2) != 0) {
            z = false;
        }
        h<String> a2 = n.a(charSequence, strArr, z);
        AppMethodBeat.o(129414);
        return a2;
    }

    public static final h<String> a(CharSequence charSequence, String[] strArr, boolean z) {
        AppMethodBeat.i(129413);
        p.h(charSequence, "$this$splitToSequence");
        p.h(strArr, "delimiters");
        h<String> d2 = i.d(a(charSequence, strArr, z, 0), new c(charSequence));
        AppMethodBeat.o(129413);
        return d2;
    }

    public static /* synthetic */ List b(CharSequence charSequence, String[] strArr) {
        AppMethodBeat.i(259498);
        List<String> a2 = n.a(charSequence, strArr);
        AppMethodBeat.o(259498);
        return a2;
    }

    public static final List<String> a(CharSequence charSequence, String[] strArr) {
        AppMethodBeat.i(129415);
        p.h(charSequence, "$this$split");
        p.h(strArr, "delimiters");
        if (strArr.length == 1) {
            String str = strArr[0];
            if (!(str.length() == 0)) {
                List<String> a2 = a(charSequence, str, false, 0);
                AppMethodBeat.o(129415);
                return a2;
            }
        }
        Iterable<f> f2 = i.f(a(charSequence, strArr, false, 0));
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(f2, 10));
        for (f fVar : f2) {
            arrayList.add(n.a(charSequence, fVar));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(129415);
        return arrayList2;
    }

    public static /* synthetic */ List b(CharSequence charSequence, char[] cArr) {
        AppMethodBeat.i(259499);
        List<String> a2 = n.a(charSequence, cArr);
        AppMethodBeat.o(259499);
        return a2;
    }

    public static final List<String> a(CharSequence charSequence, char[] cArr) {
        AppMethodBeat.i(168701);
        p.h(charSequence, "$this$split");
        p.h(cArr, "delimiters");
        if (cArr.length == 1) {
            List<String> a2 = a(charSequence, String.valueOf(cArr[0]), false, 0);
            AppMethodBeat.o(168701);
            return a2;
        }
        Iterable<f> f2 = i.f(a(charSequence, cArr, false, 0));
        ArrayList arrayList = new ArrayList(kotlin.a.j.a(f2, 10));
        for (f fVar : f2) {
            arrayList.add(n.a(charSequence, fVar));
        }
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(168701);
        return arrayList2;
    }

    private static final List<String> a(CharSequence charSequence, String str, boolean z, int i2) {
        AppMethodBeat.i(206247);
        int a2 = n.a(charSequence, str, 0, false);
        if (a2 == -1) {
            List<String> listOf = kotlin.a.j.listOf(charSequence.toString());
            AppMethodBeat.o(206247);
            return listOf;
        }
        ArrayList arrayList = new ArrayList(10);
        int i3 = 0;
        do {
            arrayList.add(charSequence.subSequence(i3, a2).toString());
            i3 = str.length() + a2;
            a2 = n.a(charSequence, str, i3, false);
        } while (a2 != -1);
        arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
        ArrayList arrayList2 = arrayList;
        AppMethodBeat.o(206247);
        return arrayList2;
    }

    public static final h<String> aQ(CharSequence charSequence) {
        AppMethodBeat.i(129417);
        p.h(charSequence, "$this$lineSequence");
        h<String> b2 = n.b(charSequence, new String[]{APLogFileUtil.SEPARATOR_LINE, "\n", "\r"}, false, 6);
        AppMethodBeat.o(129417);
        return b2;
    }

    public static final List<String> aR(CharSequence charSequence) {
        AppMethodBeat.i(129418);
        p.h(charSequence, "$this$lines");
        List<String> c2 = i.c(n.aQ(charSequence));
        AppMethodBeat.o(129418);
        return c2;
    }

    public static final String a(String str, char... cArr) {
        String str2;
        AppMethodBeat.i(129376);
        p.h(str, "$this$trimEnd");
        p.h(cArr, "chars");
        String str3 = str;
        int length = str3.length() - 1;
        while (true) {
            if (length < 0) {
                break;
            } else if (!e.contains(cArr, str3.charAt(length))) {
                str2 = str3.subSequence(0, length + 1);
                break;
            } else {
                length--;
            }
        }
        String obj = str2.toString();
        AppMethodBeat.o(129376);
        return obj;
    }

    public static final CharSequence trim(CharSequence charSequence) {
        AppMethodBeat.i(129377);
        p.h(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        boolean z = false;
        int i2 = 0;
        while (i2 <= length) {
            boolean isWhitespace = a.isWhitespace(charSequence.charAt(!z ? i2 : length));
            if (z) {
                if (!isWhitespace) {
                    break;
                }
                length--;
            } else if (!isWhitespace) {
                z = true;
            } else {
                i2++;
            }
        }
        CharSequence subSequence = charSequence.subSequence(i2, length + 1);
        AppMethodBeat.o(129377);
        return subSequence;
    }

    public static final CharSequence aM(CharSequence charSequence) {
        AppMethodBeat.i(168697);
        p.h(charSequence, "$this$trimStart");
        int length = charSequence.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!a.isWhitespace(charSequence.charAt(i2))) {
                CharSequence subSequence = charSequence.subSequence(i2, charSequence.length());
                AppMethodBeat.o(168697);
                return subSequence;
            }
        }
        AppMethodBeat.o(168697);
        return r0;
    }

    public static final String a(CharSequence charSequence, f fVar) {
        AppMethodBeat.i(129380);
        p.h(charSequence, "$this$substring");
        p.h(fVar, "range");
        String obj = charSequence.subSequence(fVar.SYU, fVar.SYV + 1).toString();
        AppMethodBeat.o(129380);
        return obj;
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"})
    public static final class a extends q implements m<CharSequence, Integer, o<? extends Integer, ? extends Integer>> {
        final /* synthetic */ char[] TTn;
        final /* synthetic */ boolean TTo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(char[] cArr, boolean z) {
            super(2);
            this.TTn = cArr;
            this.TTo = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ o<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            AppMethodBeat.i(168703);
            CharSequence charSequence2 = charSequence;
            int intValue = num.intValue();
            p.h(charSequence2, "$receiver");
            int a2 = n.a(charSequence2, this.TTn, intValue, this.TTo);
            if (a2 < 0) {
                AppMethodBeat.o(168703);
                return null;
            }
            o U = s.U(Integer.valueOf(a2), 1);
            AppMethodBeat.o(168703);
            return U;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\r\n\u0002\b\u0002\u0010\u0000\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0002H\n¢\u0006\u0002\b\u0005"}, hxF = {"<anonymous>", "Lkotlin/Pair;", "", "", "currentIndex", "invoke"})
    public static final class b extends q implements m<CharSequence, Integer, o<? extends Integer, ? extends Integer>> {
        final /* synthetic */ boolean TTo;
        final /* synthetic */ List TTp;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(List list, boolean z) {
            super(2);
            this.TTp = list;
            this.TTo = z;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Object] */
        @Override // kotlin.g.a.m
        public final /* synthetic */ o<? extends Integer, ? extends Integer> invoke(CharSequence charSequence, Integer num) {
            o oVar;
            Object obj;
            Object obj2;
            AppMethodBeat.i(129355);
            CharSequence charSequence2 = charSequence;
            int intValue = num.intValue();
            p.h(charSequence2, "$receiver");
            List list = this.TTp;
            boolean z = this.TTo;
            if (z || list.size() != 1) {
                f fVar = new f(j.mZ(intValue, 0), charSequence2.length());
                if (charSequence2 instanceof String) {
                    int i2 = fVar.SYU;
                    int i3 = fVar.SYV;
                    int i4 = fVar.lCq;
                    if (i4 < 0 ? i2 >= i3 : i2 <= i3) {
                        while (true) {
                            Iterator it = list.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    obj2 = null;
                                    break;
                                }
                                Object next = it.next();
                                String str = (String) next;
                                if (n.a(str, 0, (String) charSequence2, i2, str.length(), z)) {
                                    obj2 = next;
                                    break;
                                }
                            }
                            String str2 = (String) obj2;
                            if (str2 == null) {
                                if (i2 == i3) {
                                    break;
                                }
                                i2 += i4;
                            } else {
                                oVar = s.U(Integer.valueOf(i2), str2);
                                break;
                            }
                        }
                    }
                    oVar = null;
                } else {
                    int i5 = fVar.SYU;
                    int i6 = fVar.SYV;
                    int i7 = fVar.lCq;
                    if (i7 < 0 ? i5 >= i6 : i5 <= i6) {
                        while (true) {
                            Iterator it2 = list.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    obj = null;
                                    break;
                                }
                                Object next2 = it2.next();
                                String str3 = (String) next2;
                                if (n.a(str3, 0, charSequence2, i5, str3.length(), z)) {
                                    obj = next2;
                                    break;
                                }
                            }
                            String str4 = (String) obj;
                            if (str4 == null) {
                                if (i5 == i6) {
                                    break;
                                }
                                i5 += i7;
                            } else {
                                oVar = s.U(Integer.valueOf(i5), str4);
                                break;
                            }
                        }
                    }
                    oVar = null;
                }
            } else {
                String str5 = (String) kotlin.a.j.i(list);
                int a2 = n.a(charSequence2, str5, intValue, false, 4);
                if (a2 >= 0) {
                    oVar = s.U(Integer.valueOf(a2), str5);
                }
                oVar = null;
            }
            if (oVar != null) {
                o U = s.U(oVar.first, Integer.valueOf(oVar.second.length()));
                AppMethodBeat.o(129355);
                return U;
            }
            AppMethodBeat.o(129355);
            return null;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, hxF = {"<anonymous>", "", LocaleUtil.ITALIAN, "Lkotlin/ranges/IntRange;", "invoke"})
    static final class c extends q implements kotlin.g.a.b<f, String> {
        final /* synthetic */ CharSequence TTq;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(CharSequence charSequence) {
            super(1);
            this.TTq = charSequence;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ String invoke(f fVar) {
            AppMethodBeat.i(129449);
            f fVar2 = fVar;
            p.h(fVar2, LocaleUtil.ITALIAN);
            String a2 = n.a(this.TTq, fVar2);
            AppMethodBeat.o(129449);
            return a2;
        }
    }

    private static /* synthetic */ h a(CharSequence charSequence, char[] cArr, boolean z, int i2) {
        AppMethodBeat.i(206243);
        e eVar = new e(charSequence, 0, 0, new a(cArr, false));
        AppMethodBeat.o(206243);
        return eVar;
    }

    private static /* synthetic */ h a(CharSequence charSequence, String[] strArr, boolean z, int i2) {
        AppMethodBeat.i(206244);
        e eVar = new e(charSequence, 0, 0, new b(e.asList(strArr), z));
        AppMethodBeat.o(206244);
        return eVar;
    }
}
