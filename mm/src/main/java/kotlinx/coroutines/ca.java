package kotlinx.coroutines;

import com.facebook.internal.AnalyticsEvents;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.bu;
import kotlinx.coroutines.internal.j;
import kotlinx.coroutines.internal.k;
import kotlinx.coroutines.internal.q;
import kotlinx.coroutines.internal.u;

@l(hxD = {1, 1, 16}, hxE = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0001\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0017\u0018\u00002\u00020X2\u00020\u00172\u00030\u00012\u00030Å\u0001:\u0006Ô\u0001Õ\u0001Ö\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J+\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ%\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u000e\u001a\u00020\r2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0015\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u001c\u0010\u001dJ\u0015\u0010\u001f\u001a\u0004\u0018\u00010\u0005H@ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010\u001dJ\u0019\u0010!\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\rH\u0017¢\u0006\u0004\b!\u0010\"J\u001f\u0010!\u001a\u00020\u00112\u000e\u0010 \u001a\n\u0018\u00010#j\u0004\u0018\u0001`$H\u0016¢\u0006\u0004\b!\u0010%J\u0017\u0010&\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\r¢\u0006\u0004\b&\u0010\"J\u0019\u0010)\u001a\u00020\u00012\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\b'\u0010(J\u0017\u0010*\u001a\u00020\u00112\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b*\u0010+J\u001b\u0010,\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\b.\u0010\"J\u000f\u00100\u001a\u00020/H\u0014¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\rH\u0016¢\u0006\u0004\b2\u0010\"J!\u00105\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b5\u00106J)\u0010;\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u0002072\u0006\u00109\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b;\u0010<J\u0019\u0010=\u001a\u00020\r2\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\b=\u0010>J(\u0010C\u001a\u00020@2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010/2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\rH\b¢\u0006\u0004\bA\u0010BJ#\u0010D\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u0002072\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\bD\u0010EJ\u0019\u0010F\u001a\u0004\u0018\u0001082\u0006\u0010\u0014\u001a\u000203H\u0002¢\u0006\u0004\bF\u0010GJ\u0011\u0010H\u001a\u00060#j\u0002`$¢\u0006\u0004\bH\u0010IJ\u0013\u0010J\u001a\u00060#j\u0002`$H\u0016¢\u0006\u0004\bJ\u0010IJ\u0011\u0010M\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bK\u0010LJ\u000f\u0010N\u001a\u0004\u0018\u00010\r¢\u0006\u0004\bN\u0010OJ'\u0010P\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0014\u001a\u0002072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0002¢\u0006\u0004\bP\u0010QJ\u0019\u0010R\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0014\u001a\u000203H\u0002¢\u0006\u0004\bR\u0010SJ\u0017\u0010U\u001a\u00020\u00012\u0006\u0010T\u001a\u00020\rH\u0014¢\u0006\u0004\bU\u0010\"J\u0017\u0010W\u001a\u00020\u00112\u0006\u0010T\u001a\u00020\rH\u0010¢\u0006\u0004\bV\u0010+J\u0019\u0010\\\u001a\u00020\u00112\b\u0010Y\u001a\u0004\u0018\u00010XH\u0000¢\u0006\u0004\bZ\u0010[JF\u0010e\u001a\u00020d2\u0006\u0010]\u001a\u00020\u00012\u0006\u0010^\u001a\u00020\u00012'\u0010c\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110_j\u0002`b¢\u0006\u0004\be\u0010fJ6\u0010e\u001a\u00020d2'\u0010c\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110_j\u0002`b¢\u0006\u0004\be\u0010gJ\u0013\u0010h\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0004\bh\u0010\u001dJ\u000f\u0010i\u001a\u00020\u0001H\u0002¢\u0006\u0004\bi\u0010jJ\u0013\u0010k\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0004\bk\u0010\u001dJ&\u0010n\u001a\u00020m2\u0014\u0010l\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00110_H\b¢\u0006\u0004\bn\u0010oJ\u001b\u0010p\u001a\u0004\u0018\u00010\u00052\b\u0010 \u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0004\bp\u0010-J\u0019\u0010r\u001a\u00020\u00012\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bq\u0010(J\u001b\u0010t\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0000¢\u0006\u0004\bs\u0010-JD\u0010u\u001a\u0006\u0012\u0002\b\u00030\t2'\u0010c\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b`\u0012\b\ba\u0012\u0004\b\b( \u0012\u0004\u0012\u00020\u00110_j\u0002`b2\u0006\u0010]\u001a\u00020\u0001H\u0002¢\u0006\u0004\bu\u0010vJ\u000f\u0010x\u001a\u00020/H\u0010¢\u0006\u0004\bw\u00101J\u001f\u0010y\u001a\u00020\u00112\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\by\u0010zJ2\u0010|\u001a\u00020\u0011\"\u000e\b\u0000\u0010{\u0018\u0001*\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\b\u001a\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\rH\b¢\u0006\u0004\b|\u0010zJ\u0019\u0010]\u001a\u00020\u00112\b\u0010 \u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b]\u0010+J\u0019\u0010}\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0014¢\u0006\u0004\b}\u0010\u0016J\u0010\u0010\u0001\u001a\u00020\u0011H\u0010¢\u0006\u0004\b~\u0010J\u001a\u0010\u0001\u001a\u00020\u00112\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\u001b\u0010\u0001\u001a\u00020\u00112\u0007\u0010\u0014\u001a\u00030\u0001H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u00112\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tH\u0002¢\u0006\u0006\b\u0001\u0010\u0001JI\u0010\u0001\u001a\u00020\u0011\"\u0005\b\u0000\u0010\u00012\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u00012\u001d\u0010l\u001a\u0019\b\u0001\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00000\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050_ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001JX\u0010\u0001\u001a\u00020\u0011\"\u0004\b\u0000\u0010{\"\u0005\b\u0001\u0010\u00012\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u00012$\u0010l\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u00112\n\u0010\n\u001a\u0006\u0012\u0002\b\u00030\tH\u0000¢\u0006\u0006\b\u0001\u0010\u0001JX\u0010\u0001\u001a\u00020\u0011\"\u0004\b\u0000\u0010{\"\u0005\b\u0001\u0010\u00012\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u00028\u00010\u00012$\u0010l\u001a \b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u000b\u0012\t\u0012\u0004\u0012\u00028\u00010\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0001H\u0000ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u000f\u0010\u0001\u001a\u00020\u0001¢\u0006\u0005\b\u0001\u0010jJ\u001d\u0010\u0001\u001a\u00030\u00012\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u001c\u0010\u0001\u001a\u00020/2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b\u0001\u0010\u0001J\u0011\u0010\u0001\u001a\u00020/H\u0007¢\u0006\u0005\b\u0001\u00101J\u0011\u0010\u0001\u001a\u00020/H\u0016¢\u0006\u0005\b\u0001\u00101J$\u0010 \u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b \u0001\u0010¡\u0001J\"\u0010¢\u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002032\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0006\b¢\u0001\u0010£\u0001J(\u0010¤\u0001\u001a\u0004\u0018\u00010\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u00052\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b¤\u0001\u0010¥\u0001J&\u0010¦\u0001\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u0002032\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0006\b¦\u0001\u0010§\u0001J-\u0010¨\u0001\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u0002072\u0006\u0010\u0018\u001a\u0002082\b\u0010:\u001a\u0004\u0018\u00010\u0005H\u0010¢\u0006\u0006\b¨\u0001\u0010©\u0001J\u0019\u0010«\u0001\u001a\u0004\u0018\u000108*\u00030ª\u0001H\u0002¢\u0006\u0006\b«\u0001\u0010¬\u0001J\u001f\u0010­\u0001\u001a\u00020\u0011*\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0005\b­\u0001\u0010zJ&\u0010®\u0001\u001a\u00060#j\u0002`$*\u00020\r2\n\b\u0002\u0010?\u001a\u0004\u0018\u00010/H\u0004¢\u0006\u0006\b®\u0001\u0010¯\u0001R\u001d\u0010³\u0001\u001a\t\u0012\u0004\u0012\u00020X0°\u00018F@\u0006¢\u0006\b\u001a\u0006\b±\u0001\u0010²\u0001R\u001a\u0010µ\u0001\u001a\u0004\u0018\u00010\r8D@\u0004X\u0004¢\u0006\u0007\u001a\u0005\b´\u0001\u0010OR\u0018\u0010·\u0001\u001a\u00020\u00018D@\u0004X\u0004¢\u0006\u0007\u001a\u0005\b¶\u0001\u0010jR\u0018\u0010¹\u0001\u001a\u00020\u00018P@\u0010X\u0004¢\u0006\u0007\u001a\u0005\b¸\u0001\u0010jR\u0018\u0010º\u0001\u001a\u00020\u00018V@\u0016X\u0004¢\u0006\u0007\u001a\u0005\bº\u0001\u0010jR\u0015\u0010»\u0001\u001a\u00020\u00018F@\u0006¢\u0006\u0007\u001a\u0005\b»\u0001\u0010jR\u0015\u0010¼\u0001\u001a\u00020\u00018F@\u0006¢\u0006\u0007\u001a\u0005\b¼\u0001\u0010jR\u0015\u0010½\u0001\u001a\u00020\u00018F@\u0006¢\u0006\u0007\u001a\u0005\b½\u0001\u0010jR\u0018\u0010¾\u0001\u001a\u00020\u00018T@\u0014X\u0004¢\u0006\u0007\u001a\u0005\b¾\u0001\u0010jR\u001b\u0010Â\u0001\u001a\u0007\u0012\u0002\b\u00030¿\u00018F@\u0006¢\u0006\b\u001a\u0006\bÀ\u0001\u0010Á\u0001R\u0018\u0010Ä\u0001\u001a\u00020\u00018P@\u0010X\u0004¢\u0006\u0007\u001a\u0005\bÃ\u0001\u0010jR\u0017\u0010È\u0001\u001a\u00030Å\u00018F@\u0006¢\u0006\b\u001a\u0006\bÆ\u0001\u0010Ç\u0001R.\u0010Î\u0001\u001a\u0004\u0018\u00010\u00192\t\u0010É\u0001\u001a\u0004\u0018\u00010\u00198@@@X\u000e¢\u0006\u0010\u001a\u0006\bÊ\u0001\u0010Ë\u0001\"\u0006\bÌ\u0001\u0010Í\u0001R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00058@@\u0000X\u0004¢\u0006\u0007\u001a\u0005\bÏ\u0001\u0010LR \u0010Ñ\u0001\u001a\u0004\u0018\u00010\r*\u0004\u0018\u00010\u00058B@\u0002X\u0004¢\u0006\u0007\u001a\u0005\bÐ\u0001\u0010>R\u001d\u0010Ò\u0001\u001a\u00020\u0001*\u0002038B@\u0002X\u0004¢\u0006\b\u001a\u0006\bÒ\u0001\u0010Ó\u0001\u0002\u0004\n\u0002\b\u0019¨\u0006×\u0001"}, hxF = {"Lkotlinx/coroutines/JobSupport;", "", "active", "<init>", "(Z)V", "", "expect", "Lkotlinx/coroutines/NodeList;", "list", "Lkotlinx/coroutines/JobNode;", "node", "addLastAtomic", "(Ljava/lang/Object;Lkotlinx/coroutines/NodeList;Lkotlinx/coroutines/JobNode;)Z", "", "rootCause", "", "exceptions", "", "addSuppressedExceptions", "(Ljava/lang/Throwable;Ljava/util/List;)V", "state", "afterCompletion", "(Ljava/lang/Object;)V", "Lkotlinx/coroutines/ChildJob;", "child", "Lkotlinx/coroutines/ChildHandle;", "attachChild", "(Lkotlinx/coroutines/ChildJob;)Lkotlinx/coroutines/ChildHandle;", "awaitInternal$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitInternal", "awaitSuspend", "cause", "cancel", "(Ljava/lang/Throwable;)Z", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelCoroutine", "cancelImpl$kotlinx_coroutines_core", "(Ljava/lang/Object;)Z", "cancelImpl", "cancelInternal", "(Ljava/lang/Throwable;)V", "cancelMakeCompleting", "(Ljava/lang/Object;)Ljava/lang/Object;", "cancelParent", "", "cancellationExceptionMessage", "()Ljava/lang/String;", "childCancelled", "Lkotlinx/coroutines/Incomplete;", "update", "completeStateFinalization", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)V", "Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/ChildHandleNode;", "lastChild", "proposedUpdate", "continueCompleting", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "createCauseException", "(Ljava/lang/Object;)Ljava/lang/Throwable;", "message", "Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException$kotlinx_coroutines_core", "(Ljava/lang/String;Ljava/lang/Throwable;)Lkotlinx/coroutines/JobCancellationException;", "defaultCancellationException", "finalizeFinishingState", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/lang/Object;)Ljava/lang/Object;", "firstChild", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/ChildHandleNode;", "getCancellationException", "()Ljava/util/concurrent/CancellationException;", "getChildJobCancellationCause", "getCompletedInternal$kotlinx_coroutines_core", "()Ljava/lang/Object;", "getCompletedInternal", "getCompletionExceptionOrNull", "()Ljava/lang/Throwable;", "getFinalRootCause", "(Lkotlinx/coroutines/JobSupport$Finishing;Ljava/util/List;)Ljava/lang/Throwable;", "getOrPromoteCancellingList", "(Lkotlinx/coroutines/Incomplete;)Lkotlinx/coroutines/NodeList;", "exception", "handleJobException", "handleOnCompletionException$kotlinx_coroutines_core", "handleOnCompletionException", "Lkotlinx/coroutines/Job;", "parent", "initParentJobInternal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/Job;)V", "initParentJobInternal", "onCancelling", "invokeImmediately", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "Lkotlinx/coroutines/CompletionHandler;", "handler", "Lkotlinx/coroutines/DisposableHandle;", "invokeOnCompletion", "(ZZLkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "(Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/DisposableHandle;", "join", "joinInternal", "()Z", "joinSuspend", "block", "", "loopOnState", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Void;", "makeCancelling", "makeCompleting$kotlinx_coroutines_core", "makeCompleting", "makeCompletingOnce$kotlinx_coroutines_core", "makeCompletingOnce", "makeNode", "(Lkotlin/jvm/functions/Function1;Z)Lkotlinx/coroutines/JobNode;", "nameString$kotlinx_coroutines_core", "nameString", "notifyCancelling", "(Lkotlinx/coroutines/NodeList;Ljava/lang/Throwable;)V", "T", "notifyHandlers", "onCompletionInternal", "onStartInternal$kotlinx_coroutines_core", "()V", "onStartInternal", "Lkotlinx/coroutines/ParentJob;", "parentJob", "parentCancelled", "(Lkotlinx/coroutines/ParentJob;)V", "Lkotlinx/coroutines/Empty;", "promoteEmptyToNodeList", "(Lkotlinx/coroutines/Empty;)V", "promoteSingleToNodeList", "(Lkotlinx/coroutines/JobNode;)V", "R", "Lkotlinx/coroutines/selects/SelectInstance;", "select", "Lkotlin/coroutines/Continuation;", "registerSelectClause0", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function1;)V", "Lkotlin/Function2;", "registerSelectClause1Internal$kotlinx_coroutines_core", "(Lkotlinx/coroutines/selects/SelectInstance;Lkotlin/jvm/functions/Function2;)V", "registerSelectClause1Internal", "removeNode$kotlinx_coroutines_core", "removeNode", "selectAwaitCompletion$kotlinx_coroutines_core", "selectAwaitCompletion", "start", "", "startInternal", "(Ljava/lang/Object;)I", "stateString", "(Ljava/lang/Object;)Ljava/lang/String;", "toDebugString", "toString", "tryFinalizeSimpleState", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Z", "tryMakeCancelling", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Throwable;)Z", "tryMakeCompleting", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "tryMakeCompletingSlowPath", "(Lkotlinx/coroutines/Incomplete;Ljava/lang/Object;)Ljava/lang/Object;", "tryWaitForChild", "(Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)Z", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "nextChild", "(Lkotlinx/coroutines/internal/LockFreeLinkedListNode;)Lkotlinx/coroutines/ChildHandleNode;", "notifyCompletion", "toCancellationException", "(Ljava/lang/Throwable;Ljava/lang/String;)Ljava/util/concurrent/CancellationException;", "Lkotlin/sequences/Sequence;", "getChildren", "()Lkotlin/sequences/Sequence;", "children", "getCompletionCause", "completionCause", "getCompletionCauseHandled", "completionCauseHandled", "getHandlesException$kotlinx_coroutines_core", "handlesException", "isActive", "isCancelled", "isCompleted", "isCompletedExceptionally", "isScopedCoroutine", "Lkotlin/coroutines/CoroutineContext$Key;", "getKey", "()Lkotlin/coroutines/CoroutineContext$Key;", "key", "getOnCancelComplete$kotlinx_coroutines_core", "onCancelComplete", "Lkotlinx/coroutines/selects/SelectClause0;", "getOnJoin", "()Lkotlinx/coroutines/selects/SelectClause0;", "onJoin", "value", "getParentHandle$kotlinx_coroutines_core", "()Lkotlinx/coroutines/ChildHandle;", "setParentHandle$kotlinx_coroutines_core", "(Lkotlinx/coroutines/ChildHandle;)V", "parentHandle", "getState$kotlinx_coroutines_core", "getExceptionOrNull", "exceptionOrNull", "isCancelling", "(Lkotlinx/coroutines/Incomplete;)Z", "AwaitContinuation", "ChildCompletion", "Finishing", "kotlinx-coroutines-core"})
public class ca implements bu, ci, s {
    static final AtomicReferenceFieldUpdater TTD = AtomicReferenceFieldUpdater.newUpdater(ca.class, Object.class, "_state");
    volatile Object _parentHandle;
    private volatile Object _state;

    static {
        AppMethodBeat.i(118317);
        AppMethodBeat.o(118317);
    }

    public ca(boolean z) {
        AppMethodBeat.i(118311);
        this._state = z ? cb.hNt() : cb.hNx();
        this._parentHandle = null;
        AppMethodBeat.o(118311);
    }

    @Override // kotlin.d.f.b
    public final f.c<?> getKey() {
        return bu.TUO;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006H\u0016¨\u0006\u0007¸\u0006\u0000"}, hxF = {"kotlinx/coroutines/internal/LockFreeLinkedListNode$makeCondAddOp$1", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode$CondAddOp;", "prepare", "", "affected", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "Lkotlinx/coroutines/internal/Node;", "kotlinx-coroutines-core"})
    public static final class d extends k.a {
        final /* synthetic */ k TUX;
        final /* synthetic */ ca TUY;
        final /* synthetic */ Object TUZ;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(k kVar, k kVar2, ca caVar, Object obj) {
            super(kVar2);
            this.TUX = kVar;
            this.TUY = caVar;
            this.TUZ = obj;
        }

        @Override // kotlinx.coroutines.internal.c
        public final /* synthetic */ Object hNr() {
            AppMethodBeat.i(192504);
            if (this.TUY.hNm() == this.TUZ) {
                AppMethodBeat.o(192504);
                return null;
            }
            Object hNH = j.hNH();
            AppMethodBeat.o(192504);
            return hNH;
        }
    }

    public final void b(bu buVar) {
        AppMethodBeat.i(192335);
        if (an.hMK()) {
            if (!(((q) this._parentHandle) == null)) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(192335);
                throw assertionError;
            }
        }
        if (buVar == null) {
            this._parentHandle = cg.TVh;
            AppMethodBeat.o(192335);
            return;
        }
        buVar.start();
        q a2 = buVar.a(this);
        this._parentHandle = a2;
        if (isCompleted()) {
            a2.dispose();
            this._parentHandle = cg.TVh;
        }
        AppMethodBeat.o(192335);
    }

    @Override // kotlinx.coroutines.bu
    public boolean isActive() {
        AppMethodBeat.i(118278);
        Object hNm = hNm();
        if (!(hNm instanceof bp) || !((bp) hNm).isActive()) {
            AppMethodBeat.o(118278);
            return false;
        }
        AppMethodBeat.o(118278);
        return true;
    }

    @Override // kotlinx.coroutines.bu
    public final boolean isCompleted() {
        AppMethodBeat.i(192336);
        if (!(hNm() instanceof bp)) {
            AppMethodBeat.o(192336);
            return true;
        }
        AppMethodBeat.o(192336);
        return false;
    }

    private final Object a(c cVar, Object obj) {
        Object obj2;
        Throwable th;
        ArrayList arrayList;
        Throwable a2;
        v vVar;
        boolean z;
        AppMethodBeat.i(192337);
        if (an.hMK()) {
            if (!(hNm() == cVar)) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(192337);
                throw assertionError;
            }
        }
        if (an.hMK()) {
            if (!(!cVar.isSealed())) {
                AssertionError assertionError2 = new AssertionError();
                AppMethodBeat.o(192337);
                throw assertionError2;
            }
        }
        if (!an.hMK() || cVar._isCompleting != 0) {
            if (!(obj instanceof v)) {
                obj2 = null;
            } else {
                obj2 = obj;
            }
            v vVar2 = (v) obj2;
            if (vVar2 != null) {
                th = vVar2.cause;
            } else {
                th = null;
            }
            synchronized (cVar) {
                try {
                    Object obj3 = cVar._exceptionsHolder;
                    if (obj3 == null) {
                        arrayList = c.hNq();
                    } else if (obj3 instanceof Throwable) {
                        arrayList = c.hNq();
                        arrayList.add(obj3);
                    } else if (obj3 instanceof ArrayList) {
                        arrayList = (ArrayList) obj3;
                    } else {
                        IllegalStateException illegalStateException = new IllegalStateException("State is ".concat(String.valueOf(obj3)).toString());
                        AppMethodBeat.o(192337);
                        throw illegalStateException;
                    }
                    Throwable th2 = (Throwable) cVar._rootCause;
                    if (th2 != null) {
                        arrayList.add(0, th2);
                    }
                    if (th != null && (!p.j(th, th2))) {
                        arrayList.add(th);
                    }
                    cVar._exceptionsHolder = cb.hNs();
                    ArrayList arrayList2 = arrayList;
                    a2 = a(cVar, (List<? extends Throwable>) arrayList2);
                    if (a2 != null) {
                        b(a2, arrayList2);
                    }
                } catch (Throwable th3) {
                    AppMethodBeat.o(192337);
                    throw th3;
                }
            }
            if (a2 == null) {
                vVar = obj;
            } else if (a2 == th) {
                vVar = obj;
            } else {
                vVar = new v(a2);
            }
            if (a2 != null) {
                if (C(a2) || E(a2)) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    if (vVar == null) {
                        t tVar = new t("null cannot be cast to non-null type kotlinx.coroutines.CompletedExceptionally");
                        AppMethodBeat.o(192337);
                        throw tVar;
                    }
                    ((v) vVar).hME();
                }
            }
            boolean compareAndSet = TTD.compareAndSet(this, cVar, cb.gc(vVar));
            if (!an.hMK() || compareAndSet) {
                b(cVar, vVar);
                AppMethodBeat.o(192337);
                return vVar;
            }
            AssertionError assertionError3 = new AssertionError();
            AppMethodBeat.o(192337);
            throw assertionError3;
        }
        AssertionError assertionError4 = new AssertionError();
        AppMethodBeat.o(192337);
        throw assertionError4;
    }

    private final Throwable a(c cVar, List<? extends Throwable> list) {
        T t;
        T t2;
        boolean z;
        boolean z2;
        AppMethodBeat.i(118280);
        if (!list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t = null;
                    break;
                }
                T next = it.next();
                if (!(next instanceof CancellationException)) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    t = next;
                    break;
                }
            }
            T t3 = t;
            if (t3 != null) {
                AppMethodBeat.o(118280);
                return t3;
            }
            Throwable th = (Throwable) list.get(0);
            if (th instanceof cs) {
                Iterator<T> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        t2 = null;
                        break;
                    }
                    T next2 = it2.next();
                    T t4 = next2;
                    if (t4 == th || !(t4 instanceof cs)) {
                        z = false;
                        continue;
                    } else {
                        z = true;
                        continue;
                    }
                    if (z) {
                        t2 = next2;
                        break;
                    }
                }
                T t5 = t2;
                if (t5 != null) {
                    AppMethodBeat.o(118280);
                    return t5;
                }
            }
            AppMethodBeat.o(118280);
            return th;
        } else if (cVar.hNp()) {
            bv bvVar = new bv(hMn(), null, this);
            AppMethodBeat.o(118280);
            return bvVar;
        } else {
            AppMethodBeat.o(118280);
            return null;
        }
    }

    private static void b(Throwable th, List<? extends Throwable> list) {
        Throwable I;
        AppMethodBeat.i(192338);
        if (list.size() <= 1) {
            AppMethodBeat.o(192338);
            return;
        }
        Set newSetFromMap = Collections.newSetFromMap(new IdentityHashMap(list.size()));
        if (!an.hML()) {
            I = th;
        } else {
            I = kotlinx.coroutines.internal.t.I(th);
        }
        for (Throwable th2 : list) {
            if (an.hML()) {
                th2 = kotlinx.coroutines.internal.t.I(th2);
            }
            if (th2 != th && th2 != I && !(th2 instanceof CancellationException) && newSetFromMap.add(th2)) {
                kotlin.a.a(th, th2);
            }
        }
        AppMethodBeat.o(192338);
    }

    private final boolean a(bp bpVar, Object obj) {
        AppMethodBeat.i(192339);
        if (an.hMK()) {
            if (!((bpVar instanceof bf) || (bpVar instanceof bz))) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(192339);
                throw assertionError;
            }
        }
        if (an.hMK()) {
            if (!(!(obj instanceof v))) {
                AssertionError assertionError2 = new AssertionError();
                AppMethodBeat.o(192339);
                throw assertionError2;
            }
        }
        if (!TTD.compareAndSet(this, bpVar, cb.gc(obj))) {
            AppMethodBeat.o(192339);
            return false;
        }
        b(bpVar, obj);
        AppMethodBeat.o(192339);
        return true;
    }

    private final boolean C(Throwable th) {
        AppMethodBeat.i(118307);
        if (hNo()) {
            AppMethodBeat.o(118307);
            return true;
        }
        boolean z = th instanceof CancellationException;
        q qVar = (q) this._parentHandle;
        if (qVar == null || qVar == cg.TVh) {
            AppMethodBeat.o(118307);
            return z;
        } else if (qVar.B(th) || z) {
            AppMethodBeat.o(118307);
            return true;
        } else {
            AppMethodBeat.o(118307);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final int fU(Object obj) {
        AppMethodBeat.i(118287);
        if (obj instanceof bf) {
            if (((bf) obj).isActive) {
                AppMethodBeat.o(118287);
                return 0;
            } else if (!TTD.compareAndSet(this, obj, cb.hNt())) {
                AppMethodBeat.o(118287);
                return -1;
            } else {
                hMm();
                AppMethodBeat.o(118287);
                return 1;
            }
        } else if (!(obj instanceof bo)) {
            AppMethodBeat.o(118287);
            return 0;
        } else if (!TTD.compareAndSet(this, obj, ((bo) obj).TUL)) {
            AppMethodBeat.o(118287);
            return -1;
        } else {
            hMm();
            AppMethodBeat.o(118287);
            return 1;
        }
    }

    public void hMm() {
    }

    @Override // kotlinx.coroutines.bu
    public final CancellationException hNj() {
        bv bvVar;
        AppMethodBeat.i(118288);
        Object hNm = hNm();
        if (hNm instanceof c) {
            Throwable th = (Throwable) ((c) hNm)._rootCause;
            if (th == null || (bvVar = d(th, getClass().getSimpleName() + " is cancelling")) == null) {
                IllegalStateException illegalStateException = new IllegalStateException("Job is still new or active: ".concat(String.valueOf(this)).toString());
                AppMethodBeat.o(118288);
                throw illegalStateException;
            }
        } else if (hNm instanceof bp) {
            IllegalStateException illegalStateException2 = new IllegalStateException("Job is still new or active: ".concat(String.valueOf(this)).toString());
            AppMethodBeat.o(118288);
            throw illegalStateException2;
        } else if (hNm instanceof v) {
            CancellationException d2 = d(((v) hNm).cause, null);
            AppMethodBeat.o(118288);
            return d2;
        } else {
            bvVar = new bv(getClass().getSimpleName() + " has completed normally", null, this);
        }
        AppMethodBeat.o(118288);
        return bvVar;
    }

    private CancellationException d(Throwable th, String str) {
        Throwable th2;
        AppMethodBeat.i(118289);
        if (!(th instanceof CancellationException)) {
            th2 = null;
        } else {
            th2 = th;
        }
        bv bvVar = (CancellationException) th2;
        if (bvVar == null) {
            if (str == null) {
                str = hMn();
            }
            bvVar = new bv(str, th, this);
        }
        AppMethodBeat.o(118289);
        return bvVar;
    }

    @Override // kotlinx.coroutines.bu
    public final bc X(kotlin.g.a.b<? super Throwable, x> bVar) {
        AppMethodBeat.i(258811);
        bc b2 = b(false, true, bVar);
        AppMethodBeat.o(258811);
        return b2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x006d, code lost:
        if (r0 == null) goto L_0x006f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlinx.coroutines.bz<?> a(kotlin.g.a.b<? super java.lang.Throwable, kotlin.x> r7, boolean r8) {
        /*
        // Method dump skipped, instructions count: 128
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.ca.a(kotlin.g.a.b, boolean):kotlinx.coroutines.bz");
    }

    private final boolean a(Object obj, cf cfVar, bz<?> bzVar) {
        AppMethodBeat.i(118292);
        cf cfVar2 = cfVar;
        while (true) {
            switch (cfVar2.hNK().a(bzVar, cfVar2, new d(bzVar, bzVar, this, obj))) {
                case 1:
                    AppMethodBeat.o(118292);
                    return true;
                case 2:
                    AppMethodBeat.o(118292);
                    return false;
            }
        }
    }

    private final void a(bz<?> bzVar) {
        AppMethodBeat.i(118293);
        bzVar.c(new cf());
        TTD.compareAndSet(this, bzVar, j.gf(bzVar.hNI()));
        AppMethodBeat.o(118293);
    }

    public boolean hNk() {
        return false;
    }

    /* access modifiers changed from: protected */
    public String hMn() {
        return "Job was cancelled";
    }

    @Override // kotlinx.coroutines.s
    public final void a(ci ciVar) {
        AppMethodBeat.i(118295);
        fV(ciVar);
        AppMethodBeat.o(118295);
    }

    public boolean B(Throwable th) {
        AppMethodBeat.i(192343);
        if (th instanceof CancellationException) {
            AppMethodBeat.o(192343);
            return true;
        } else if (!fV(th) || !hNl()) {
            AppMethodBeat.o(192343);
            return false;
        } else {
            AppMethodBeat.o(192343);
            return true;
        }
    }

    public final boolean D(Throwable th) {
        AppMethodBeat.i(192344);
        boolean fV = fV(th);
        AppMethodBeat.o(192344);
        return fV;
    }

    private boolean fV(Object obj) {
        AppMethodBeat.i(192345);
        Object hNu = cb.hNu();
        if (!hNk() || (hNu = fW(obj)) != cb.TVb) {
            if (hNu == cb.hNu()) {
                hNu = fY(obj);
            }
            if (hNu == cb.hNu()) {
                AppMethodBeat.o(192345);
                return true;
            } else if (hNu == cb.TVb) {
                AppMethodBeat.o(192345);
                return true;
            } else if (hNu == cb.hNv()) {
                AppMethodBeat.o(192345);
                return false;
            } else {
                fS(hNu);
                AppMethodBeat.o(192345);
                return true;
            }
        } else {
            AppMethodBeat.o(192345);
            return true;
        }
    }

    @Override // kotlinx.coroutines.ci
    public final CancellationException hNn() {
        CancellationException cancellationException;
        CancellationException cancellationException2;
        AppMethodBeat.i(192347);
        Object hNm = hNm();
        if (hNm instanceof c) {
            cancellationException = (Throwable) ((c) hNm)._rootCause;
        } else if (hNm instanceof v) {
            cancellationException = ((v) hNm).cause;
        } else if (hNm instanceof bp) {
            IllegalStateException illegalStateException = new IllegalStateException("Cannot be cancelling child in this state: ".concat(String.valueOf(hNm)).toString());
            AppMethodBeat.o(192347);
            throw illegalStateException;
        } else {
            cancellationException = null;
        }
        if (!(cancellationException instanceof CancellationException)) {
            cancellationException2 = null;
        } else {
            cancellationException2 = cancellationException;
        }
        bv bvVar = cancellationException2;
        if (bvVar == null) {
            bvVar = new bv("Parent job is " + gb(hNm), cancellationException, this);
        }
        AppMethodBeat.o(192347);
        return bvVar;
    }

    private final Throwable fX(Object obj) {
        boolean z;
        AppMethodBeat.i(118298);
        if (obj != null) {
            z = obj instanceof Throwable;
        } else {
            z = true;
        }
        if (z) {
            if (obj != null) {
                Throwable th = (Throwable) obj;
                AppMethodBeat.o(118298);
                return th;
            }
            bv bvVar = new bv(hMn(), null, this);
            AppMethodBeat.o(118298);
            return bvVar;
        } else if (obj == null) {
            t tVar = new t("null cannot be cast to non-null type kotlinx.coroutines.ParentJob");
            AppMethodBeat.o(118298);
            throw tVar;
        } else {
            CancellationException hNn = ((ci) obj).hNn();
            AppMethodBeat.o(118298);
            return hNn;
        }
    }

    private final cf a(bp bpVar) {
        AppMethodBeat.i(118300);
        cf hMX = bpVar.hMX();
        if (hMX != null) {
            AppMethodBeat.o(118300);
            return hMX;
        } else if (bpVar instanceof bf) {
            cf cfVar = new cf();
            AppMethodBeat.o(118300);
            return cfVar;
        } else if (bpVar instanceof bz) {
            a((bz) bpVar);
            AppMethodBeat.o(118300);
            return null;
        } else {
            IllegalStateException illegalStateException = new IllegalStateException("State should have list: ".concat(String.valueOf(bpVar)).toString());
            AppMethodBeat.o(118300);
            throw illegalStateException;
        }
    }

    private final Object Y(Object obj, Object obj2) {
        AppMethodBeat.i(192350);
        if (!(obj instanceof bp)) {
            u hNu = cb.hNu();
            AppMethodBeat.o(192350);
            return hNu;
        } else if ((!(obj instanceof bf) && !(obj instanceof bz)) || (obj instanceof r) || (obj2 instanceof v)) {
            Object c2 = c((bp) obj, obj2);
            AppMethodBeat.o(192350);
            return c2;
        } else if (a((bp) obj, obj2)) {
            AppMethodBeat.o(192350);
            return obj2;
        } else {
            u hNw = cb.hNw();
            AppMethodBeat.o(192350);
            return hNw;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:47:0x008c, code lost:
        if (r0 == null) goto L_0x0091;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x008e, code lost:
        a(r5, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0093, code lost:
        if ((r9 instanceof kotlinx.coroutines.r) != false) goto L_0x00c4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0095, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x0096, code lost:
        r0 = (kotlinx.coroutines.r) r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0098, code lost:
        if (r0 != null) goto L_0x00c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x009a, code lost:
        r0 = r9.hMX();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x009e, code lost:
        if (r0 == null) goto L_0x00a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00a0, code lost:
        r1 = a((kotlinx.coroutines.internal.k) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00a6, code lost:
        if (r1 == null) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ac, code lost:
        if (a(r2, r1, r10) == false) goto L_0x00b9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x00ae, code lost:
        r0 = kotlinx.coroutines.cb.TVb;
        com.tencent.matrix.trace.core.AppMethodBeat.o(192351);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x00b9, code lost:
        r0 = a(r2, r10);
        com.tencent.matrix.trace.core.AppMethodBeat.o(192351);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x00c2, code lost:
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x00c4, code lost:
        r0 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object c(kotlinx.coroutines.bp r9, java.lang.Object r10) {
        /*
        // Method dump skipped, instructions count: 206
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.ca.c(kotlinx.coroutines.bp, java.lang.Object):java.lang.Object");
    }

    private static Throwable ga(Object obj) {
        v vVar = (v) (!(obj instanceof v) ? null : obj);
        if (vVar != null) {
            return vVar.cause;
        }
        return null;
    }

    private final boolean a(c cVar, r rVar, Object obj) {
        AppMethodBeat.i(118302);
        r rVar2 = rVar;
        while (bu.a.a(rVar2.TTH, false, false, new b(this, cVar, rVar2, obj), 1) == cg.TVh) {
            rVar2 = a((k) rVar2);
            if (rVar2 == null) {
                AppMethodBeat.o(118302);
                return false;
            }
        }
        AppMethodBeat.o(118302);
        return true;
    }

    private static r a(k kVar) {
        AppMethodBeat.i(118303);
        while (kVar.isRemoved()) {
            kVar = kVar.hNK();
        }
        k kVar2 = kVar;
        while (true) {
            kVar2 = j.gf(kVar2.hNI());
            if (!kVar2.isRemoved()) {
                if (kVar2 instanceof r) {
                    r rVar = (r) kVar2;
                    AppMethodBeat.o(118303);
                    return rVar;
                } else if (kVar2 instanceof cf) {
                    AppMethodBeat.o(118303);
                    return null;
                }
            }
        }
    }

    @Override // kotlinx.coroutines.bu
    public final q a(s sVar) {
        AppMethodBeat.i(118304);
        bc a2 = bu.a.a(this, true, false, new r(this, sVar), 2);
        if (a2 == null) {
            t tVar = new t("null cannot be cast to non-null type kotlinx.coroutines.ChildHandle");
            AppMethodBeat.o(118304);
            throw tVar;
        }
        q qVar = (q) a2;
        AppMethodBeat.o(118304);
        return qVar;
    }

    public void x(Throwable th) {
        AppMethodBeat.i(118305);
        AppMethodBeat.o(118305);
        throw th;
    }

    /* access modifiers changed from: protected */
    public boolean hNo() {
        return false;
    }

    public boolean hNl() {
        return true;
    }

    /* access modifiers changed from: protected */
    public boolean E(Throwable th) {
        return false;
    }

    /* access modifiers changed from: protected */
    public void fS(Object obj) {
    }

    public String toString() {
        AppMethodBeat.i(118308);
        String str = (hMo() + '{' + gb(hNm()) + '}') + '@' + Integer.toHexString(System.identityHashCode(this));
        AppMethodBeat.o(118308);
        return str;
    }

    private static String gb(Object obj) {
        AppMethodBeat.i(118310);
        if (obj instanceof c) {
            if (((c) obj).hNp()) {
                AppMethodBeat.o(118310);
                return "Cancelling";
            } else if (((c) obj)._isCompleting != 0) {
                AppMethodBeat.o(118310);
                return "Completing";
            } else {
                AppMethodBeat.o(118310);
                return "Active";
            }
        } else if (obj instanceof bp) {
            if (((bp) obj).isActive()) {
                AppMethodBeat.o(118310);
                return "Active";
            }
            AppMethodBeat.o(118310);
            return "New";
        } else if (obj instanceof v) {
            AppMethodBeat.o(118310);
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_CANCELLED;
        } else {
            AppMethodBeat.o(118310);
            return AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_COMPLETED;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0002\u0018\u00002\u00060\u0018j\u0002`,2\u00020-B!\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00050\rj\b\u0012\u0004\u0012\u00020\u0005`\u000eH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R(\u0010\u001e\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u00188B@BX\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u0016\u0010\u001f\u001a\u00020\u00038V@\u0016X\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0013\u0010!\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b!\u0010 R$\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u00038F@FX\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010 \"\u0004\b\"\u0010#R\u0013\u0010$\u001a\u00020\u00038F@\u0006¢\u0006\u0006\u001a\u0004\b$\u0010 R\u001c\u0010\u0002\u001a\u00020\u00018\u0016@\u0016X\u0004¢\u0006\f\n\u0004\b\u0002\u0010%\u001a\u0004\b&\u0010'R(\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u00058F@FX\u000e¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010\f¨\u0006+"}, hxF = {"Lkotlinx/coroutines/JobSupport$Finishing;", "Lkotlinx/coroutines/NodeList;", "list", "", "isCompleting", "", "rootCause", "<init>", "(Lkotlinx/coroutines/NodeList;ZLjava/lang/Throwable;)V", "exception", "", "addExceptionLocked", "(Ljava/lang/Throwable;)V", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "allocateList", "()Ljava/util/ArrayList;", "proposedException", "", "sealLocked", "(Ljava/lang/Throwable;)Ljava/util/List;", "", "toString", "()Ljava/lang/String;", "", "value", "getExceptionsHolder", "()Ljava/lang/Object;", "setExceptionsHolder", "(Ljava/lang/Object;)V", "exceptionsHolder", "isActive", "()Z", "isCancelling", "setCompleting", "(Z)V", "isSealed", "Lkotlinx/coroutines/NodeList;", "getList", "()Lkotlinx/coroutines/NodeList;", "getRootCause", "()Ljava/lang/Throwable;", "setRootCause", "kotlinx-coroutines-core", "Lkotlinx/coroutines/internal/SynchronizedObject;", "Lkotlinx/coroutines/Incomplete;"})
    public static final class c implements bp {
        final cf TUL;
        volatile Object _exceptionsHolder;
        volatile int _isCompleting = 0;
        volatile Object _rootCause;

        public c(cf cfVar, Throwable th) {
            AppMethodBeat.i(118225);
            this.TUL = cfVar;
            this._rootCause = th;
            this._exceptionsHolder = null;
            AppMethodBeat.o(118225);
        }

        @Override // kotlinx.coroutines.bp
        public final cf hMX() {
            return this.TUL;
        }

        static ArrayList<Throwable> hNq() {
            AppMethodBeat.i(118223);
            ArrayList<Throwable> arrayList = new ArrayList<>(4);
            AppMethodBeat.o(118223);
            return arrayList;
        }

        /* JADX WARN: Type inference failed for: r1v3, types: [boolean, int] */
        public final String toString() {
            AppMethodBeat.i(118224);
            String str = "Finishing[cancelling=" + hNp() + ", completing=" + ((boolean) this._isCompleting) + ", rootCause=" + ((Throwable) this._rootCause) + ", exceptions=" + this._exceptionsHolder + ", list=" + this.TUL + ']';
            AppMethodBeat.o(118224);
            return str;
        }

        public final boolean isSealed() {
            AppMethodBeat.i(118221);
            if (this._exceptionsHolder == cb.hNs()) {
                AppMethodBeat.o(118221);
                return true;
            }
            AppMethodBeat.o(118221);
            return false;
        }

        public final boolean hNp() {
            return ((Throwable) this._rootCause) != null;
        }

        @Override // kotlinx.coroutines.bp
        public final boolean isActive() {
            return ((Throwable) this._rootCause) == null;
        }

        /* JADX DEBUG: Multi-variable search result rejected for r1v5, resolved type: java.util.ArrayList<java.lang.Throwable> */
        /* JADX WARN: Multi-variable type inference failed */
        public final void F(Throwable th) {
            AppMethodBeat.i(118222);
            Throwable th2 = (Throwable) this._rootCause;
            if (th2 == null) {
                this._rootCause = th;
                AppMethodBeat.o(118222);
            } else if (th == th2) {
                AppMethodBeat.o(118222);
            } else {
                Object obj = this._exceptionsHolder;
                if (obj == null) {
                    this._exceptionsHolder = th;
                    AppMethodBeat.o(118222);
                } else if (obj instanceof Throwable) {
                    if (th == obj) {
                        AppMethodBeat.o(118222);
                        return;
                    }
                    ArrayList<Throwable> hNq = hNq();
                    hNq.add(obj);
                    hNq.add(th);
                    this._exceptionsHolder = hNq;
                    AppMethodBeat.o(118222);
                } else if (obj instanceof ArrayList) {
                    ((ArrayList) obj).add(th);
                    AppMethodBeat.o(118222);
                } else {
                    IllegalStateException illegalStateException = new IllegalStateException("State is ".concat(String.valueOf(obj)).toString());
                    AppMethodBeat.o(118222);
                    throw illegalStateException;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, hxF = {"Lkotlinx/coroutines/JobSupport$ChildCompletion;", "Lkotlinx/coroutines/JobNode;", "Lkotlinx/coroutines/Job;", "parent", "Lkotlinx/coroutines/JobSupport;", "state", "Lkotlinx/coroutines/JobSupport$Finishing;", "child", "Lkotlinx/coroutines/ChildHandleNode;", "proposedUpdate", "", "(Lkotlinx/coroutines/JobSupport;Lkotlinx/coroutines/JobSupport$Finishing;Lkotlinx/coroutines/ChildHandleNode;Ljava/lang/Object;)V", "invoke", "", "cause", "", "toString", "", "kotlinx-coroutines-core"})
    public static final class b extends bz<bu> {
        private final ca TUT;
        private final c TUU;
        private final r TUV;
        private final Object TUW;

        public b(ca caVar, c cVar, r rVar, Object obj) {
            super(rVar.TTH);
            AppMethodBeat.i(118262);
            this.TUT = caVar;
            this.TUU = cVar;
            this.TUV = rVar;
            this.TUW = obj;
            AppMethodBeat.o(118262);
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Throwable th) {
            AppMethodBeat.i(118260);
            y(th);
            x xVar = x.SXb;
            AppMethodBeat.o(118260);
            return xVar;
        }

        @Override // kotlinx.coroutines.z
        public final void y(Throwable th) {
            AppMethodBeat.i(118259);
            ca.a(this.TUT, this.TUU, this.TUV, this.TUW);
            AppMethodBeat.o(118259);
        }

        @Override // kotlinx.coroutines.internal.k
        public final String toString() {
            AppMethodBeat.i(118261);
            String str = "ChildCompletion[" + this.TUV + ", " + this.TUW + ']';
            AppMethodBeat.o(118261);
            return str;
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0014R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, hxF = {"Lkotlinx/coroutines/JobSupport$AwaitContinuation;", "T", "Lkotlinx/coroutines/CancellableContinuationImpl;", "delegate", "Lkotlin/coroutines/Continuation;", "job", "Lkotlinx/coroutines/JobSupport;", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/JobSupport;)V", "getContinuationCancellationCause", "", "parent", "Lkotlinx/coroutines/Job;", "nameString", "", "kotlinx-coroutines-core"})
    public static final class a<T> extends l<T> {
        private final ca TUS;

        public a(kotlin.d.d<? super T> dVar, ca caVar) {
            super(dVar);
            AppMethodBeat.i(118133);
            this.TUS = caVar;
            AppMethodBeat.o(118133);
        }

        @Override // kotlinx.coroutines.l
        public final Throwable a(bu buVar) {
            Throwable th;
            AppMethodBeat.i(118131);
            Object hNm = this.TUS.hNm();
            if ((hNm instanceof c) && (th = (Throwable) ((c) hNm)._rootCause) != null) {
                AppMethodBeat.o(118131);
                return th;
            } else if (hNm instanceof v) {
                Throwable th2 = ((v) hNm).cause;
                AppMethodBeat.o(118131);
                return th2;
            } else {
                CancellationException hNj = buVar.hNj();
                AppMethodBeat.o(118131);
                return hNj;
            }
        }

        /* access modifiers changed from: protected */
        @Override // kotlinx.coroutines.l
        public final String hMy() {
            AppMethodBeat.i(118132);
            AppMethodBeat.o(118132);
            return "AwaitContinuation";
        }
    }

    public final Object hNm() {
        AppMethodBeat.i(118277);
        while (true) {
            Object obj = this._state;
            if (!(obj instanceof q)) {
                AppMethodBeat.o(118277);
                return obj;
            }
            ((q) obj).ge(this);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        if (r2 == null) goto L_0x003f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void a(kotlinx.coroutines.cf r9, java.lang.Throwable r10) {
        /*
        // Method dump skipped, instructions count: 118
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.ca.a(kotlinx.coroutines.cf, java.lang.Throwable):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003d, code lost:
        if (r2 == null) goto L_0x003f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void b(kotlinx.coroutines.cf r9, java.lang.Throwable r10) {
        /*
        // Method dump skipped, instructions count: 119
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.ca.b(kotlinx.coroutines.cf, java.lang.Throwable):void");
    }

    @Override // kotlinx.coroutines.bu
    public final boolean start() {
        AppMethodBeat.i(118286);
        while (true) {
            switch (fU(hNm())) {
                case 0:
                    AppMethodBeat.o(118286);
                    return false;
                case 1:
                    AppMethodBeat.o(118286);
                    return true;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v8, types: [kotlinx.coroutines.bo] */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009a, code lost:
        r5 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ac, code lost:
        r4 = r5;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    @Override // kotlinx.coroutines.bu
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlinx.coroutines.bc b(boolean r10, boolean r11, kotlin.g.a.b<? super java.lang.Throwable, kotlin.x> r12) {
        /*
        // Method dump skipped, instructions count: 255
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.ca.b(boolean, boolean, kotlin.g.a.b):kotlinx.coroutines.bc");
    }

    @Override // kotlinx.coroutines.bu
    public final void a(CancellationException cancellationException) {
        AppMethodBeat.i(192342);
        fV(new bv(hMn(), null, this));
        AppMethodBeat.o(192342);
    }

    private final Object fW(Object obj) {
        Object Y;
        AppMethodBeat.i(192346);
        do {
            Object hNm = hNm();
            if (!(hNm instanceof bp) || ((hNm instanceof c) && ((c) hNm)._isCompleting != 0)) {
                u hNu = cb.hNu();
                AppMethodBeat.o(192346);
                return hNu;
            }
            Y = Y(hNm, new v(fX(obj)));
        } while (Y == cb.hNw());
        AppMethodBeat.o(192346);
        return Y;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004d, code lost:
        if (r1 == null) goto L_0x0056;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x004f, code lost:
        a(((kotlinx.coroutines.ca.c) r2).TUL, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0056, code lost:
        r1 = kotlinx.coroutines.cb.hNu();
        com.tencent.matrix.trace.core.AppMethodBeat.o(192348);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:?, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object fY(java.lang.Object r12) {
        /*
        // Method dump skipped, instructions count: 282
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.ca.fY(java.lang.Object):java.lang.Object");
    }

    public final Object fZ(Object obj) {
        Object Y;
        AppMethodBeat.i(192349);
        do {
            Y = Y(hNm(), obj);
            if (Y == cb.hNu()) {
                IllegalStateException illegalStateException = new IllegalStateException("Job " + this + " is already complete or completing, but is being completed with " + obj, ga(obj));
                AppMethodBeat.o(192349);
                throw illegalStateException;
            }
        } while (Y == cb.hNw());
        AppMethodBeat.o(192349);
        return Y;
    }

    private final void b(bp bpVar, Object obj) {
        Object obj2;
        Throwable th = null;
        AppMethodBeat.i(192340);
        q qVar = (q) this._parentHandle;
        if (qVar != null) {
            qVar.dispose();
            this._parentHandle = cg.TVh;
        }
        if (!(obj instanceof v)) {
            obj2 = null;
        } else {
            obj2 = obj;
        }
        v vVar = (v) obj2;
        if (vVar != null) {
            th = vVar.cause;
        }
        if (bpVar instanceof bz) {
            try {
                ((bz) bpVar).y(th);
                AppMethodBeat.o(192340);
            } catch (Throwable th2) {
                x(new aa("Exception in completion handler " + bpVar + " for " + this, th2));
                AppMethodBeat.o(192340);
            }
        } else {
            cf hMX = bpVar.hMX();
            if (hMX != null) {
                b(hMX, th);
                AppMethodBeat.o(192340);
                return;
            }
            AppMethodBeat.o(192340);
        }
    }

    public String hMo() {
        AppMethodBeat.i(118309);
        String simpleName = getClass().getSimpleName();
        AppMethodBeat.o(118309);
        return simpleName;
    }

    @Override // kotlin.d.f
    public f plus(f fVar) {
        AppMethodBeat.i(118312);
        f a2 = f.b.a.a(this, fVar);
        AppMethodBeat.o(118312);
        return a2;
    }

    @Override // kotlin.d.f
    public <R> R fold(R r, m<? super R, ? super f.b, ? extends R> mVar) {
        AppMethodBeat.i(118313);
        R r2 = (R) f.b.a.a(this, r, mVar);
        AppMethodBeat.o(118313);
        return r2;
    }

    @Override // kotlin.d.f.b, kotlin.d.f
    public <E extends f.b> E get(f.c<E> cVar) {
        AppMethodBeat.i(118314);
        E e2 = (E) f.b.a.a(this, cVar);
        AppMethodBeat.o(118314);
        return e2;
    }

    @Override // kotlin.d.f
    public f minusKey(f.c<?> cVar) {
        AppMethodBeat.i(118315);
        f b2 = f.b.a.b(this, cVar);
        AppMethodBeat.o(118315);
        return b2;
    }

    public static final /* synthetic */ void a(ca caVar, c cVar, r rVar, Object obj) {
        AppMethodBeat.i(118316);
        if (an.hMK()) {
            if (!(caVar.hNm() == cVar)) {
                AssertionError assertionError = new AssertionError();
                AppMethodBeat.o(118316);
                throw assertionError;
            }
        }
        r a2 = a((k) rVar);
        if (a2 == null || !caVar.a(cVar, a2, obj)) {
            caVar.fS(caVar.a(cVar, obj));
        }
        AppMethodBeat.o(118316);
    }
}
