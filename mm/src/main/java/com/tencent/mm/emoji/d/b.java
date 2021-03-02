package com.tencent.mm.emoji.d;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.kernel.b.h;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.HashSet;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0002J \u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004J\u0016\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\tJ\u0016\u0010\u0015\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000RJ\u0010\u0005\u001a>\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n0\u0006j\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\t0\bj\b\u0012\u0004\u0012\u00020\t`\n`\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, hxF = {"Lcom/tencent/mm/emoji/upload/EmojiCaptureCallbackDispatcher;", "", "()V", "TAG", "", "callbackMap", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "Lcom/tencent/mm/emoji/upload/EmojiCaptureCallback;", "Lkotlin/collections/HashSet;", "Lkotlin/collections/HashMap;", "broadcastResult", "", "timeEnter", "success", "", "md5", "dispatch", "registerCallback", "callback", "unregisterCallback", "plugin-emojisdk_release"})
public final class b {
    private static final String TAG = TAG;
    private static final HashMap<Long, HashSet<a>> hdu = new HashMap<>();
    public static final b hdv = new b();

    static {
        AppMethodBeat.i(105771);
        AppMethodBeat.o(105771);
    }

    private b() {
    }

    public static void a(long j2, a aVar) {
        AppMethodBeat.i(105768);
        p.h(aVar, "callback");
        d.h(new C0323b(j2, aVar));
        AppMethodBeat.o(105768);
    }

    public static void b(long j2, a aVar) {
        AppMethodBeat.i(105769);
        p.h(aVar, "callback");
        d.h(new c(j2, aVar));
        AppMethodBeat.o(105769);
    }

    public static void b(long j2, boolean z, String str) {
        AppMethodBeat.i(105770);
        Log.i(TAG, "dispatch: " + j2 + ", " + z + ", " + str);
        d.h(new a(j2, z, str));
        h azG = g.aAe().azG();
        p.g(azG, "MMKernel.process().current()");
        if (azG.aBb()) {
            Intent intent = new Intent("com.tencent.mm.Emoji_Capture_Upload");
            intent.putExtra("upload_time_enter", j2);
            intent.putExtra("upload_success", z);
            intent.putExtra("upload_md5", str);
            MMApplicationContext.getContext().sendBroadcast(intent);
        }
        AppMethodBeat.o(105770);
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    /* renamed from: com.tencent.mm.emoji.d.b$b  reason: collision with other inner class name */
    static final class C0323b extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ long hdw;
        final /* synthetic */ a hdy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C0323b(long j2, a aVar) {
            super(0);
            this.hdw = j2;
            this.hdy = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(105766);
            b bVar = b.hdv;
            HashSet hashSet = (HashSet) b.hdu.get(Long.valueOf(this.hdw));
            if (hashSet == null) {
                HashSet hashSet2 = new HashSet();
                b bVar2 = b.hdv;
                b.hdu.put(Long.valueOf(this.hdw), hashSet2);
                hashSet = hashSet2;
            }
            hashSet.add(this.hdy);
            b bVar3 = b.hdv;
            Log.i(b.TAG, "registerCallback: " + hashSet.size());
            x xVar = x.SXb;
            AppMethodBeat.o(105766);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class c extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ long hdw;
        final /* synthetic */ a hdy;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(long j2, a aVar) {
            super(0);
            this.hdw = j2;
            this.hdy = aVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(105767);
            b bVar = b.hdv;
            HashSet hashSet = (HashSet) b.hdu.get(Long.valueOf(this.hdw));
            if (hashSet != null) {
                hashSet.remove(this.hdy);
                if (hashSet.isEmpty()) {
                    b bVar2 = b.hdv;
                    b.hdu.remove(Long.valueOf(this.hdw));
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(105767);
            return xVar;
        }
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, hxF = {"<anonymous>", "", "invoke"})
    static final class a extends q implements kotlin.g.a.a<x> {
        final /* synthetic */ boolean $success;
        final /* synthetic */ long hdw;
        final /* synthetic */ String hdx;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(long j2, boolean z, String str) {
            super(0);
            this.hdw = j2;
            this.$success = z;
            this.hdx = str;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.a
        public final /* synthetic */ x invoke() {
            AppMethodBeat.i(105765);
            b bVar = b.hdv;
            HashSet<a> hashSet = (HashSet) b.hdu.get(Long.valueOf(this.hdw));
            if (hashSet != null) {
                for (a aVar : hashSet) {
                    aVar.a(this.hdw, this.$success, this.hdx);
                }
            }
            x xVar = x.SXb;
            AppMethodBeat.o(105765);
            return xVar;
        }
    }
}
