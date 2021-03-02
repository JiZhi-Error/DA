package com.tencent.magicbrush.utils;

import com.tencent.magicbrush.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.BuildConfig;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import java.util.ArrayList;
import java.util.List;
import kotlin.g.a.b;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tJ\u0006\u0010\n\u001a\u00020\u0007J&\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0001\u0010\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\r0\u000fJ\u001a\u0010\u0010\u001a\u00020\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u000fJ3\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\r0\f\"\u0004\b\u0001\u0010\r2\u0006\u0010\u0011\u001a\u0002H\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u0002H\r0\u000f¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00072\u0006\u0010\b\u001a\u00028\u0000¢\u0006\u0002\u0010\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, hxF = {"Lcom/tencent/magicbrush/utils/ListenerList;", "T", "", "()V", "listeners", "", "add", "", "l", "(Ljava/lang/Object;)V", "clear", "dispatch", "", "R", "block", "Lkotlin/Function1;", "dispatchNoThrow", BuildConfig.KINDA_DEFAULT, "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/util/List;", "remove", "lib-magicbrush-nano_release"})
public final class c<T> {
    private final List<T> listeners = new ArrayList();

    public c() {
        AppMethodBeat.i(140291);
        AppMethodBeat.o(140291);
    }

    public final <R> List<R> b(b<? super T, ? extends R> bVar) {
        AppMethodBeat.i(140288);
        p.h(bVar, "block");
        ArrayList<T> arrayList = new ArrayList();
        synchronized (this.listeners) {
            try {
                for (T t : this.listeners) {
                    arrayList.add(t);
                }
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(140288);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (T t2 : arrayList) {
            arrayList2.add(bVar.invoke(t2));
        }
        return arrayList2;
    }

    public final void c(b<? super T, x> bVar) {
        AppMethodBeat.i(162128);
        p.h(bVar, "block");
        b(new a(bVar));
        AppMethodBeat.o(162128);
    }

    public final void add(T t) {
        AppMethodBeat.i(140289);
        synchronized (this.listeners) {
            try {
                this.listeners.add(t);
            } finally {
                AppMethodBeat.o(140289);
            }
        }
    }

    public final void remove(T t) {
        AppMethodBeat.i(206888);
        synchronized (this.listeners) {
            try {
                this.listeners.remove(t);
            } finally {
                AppMethodBeat.o(206888);
            }
        }
    }

    public final void clear() {
        AppMethodBeat.i(140290);
        synchronized (this.listeners) {
            try {
                this.listeners.clear();
                x xVar = x.SXb;
            } finally {
                AppMethodBeat.o(140290);
            }
        }
    }

    /* access modifiers changed from: package-private */
    @l(hxD = {1, 1, 16}, hxE = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, hxF = {"<anonymous>", "", "T", LocaleUtil.ITALIAN, "invoke", "(Ljava/lang/Object;)V"})
    public static final class a extends q implements b<T, x> {
        final /* synthetic */ b cPt;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(b bVar) {
            super(1);
            this.cPt = bVar;
        }

        /* Return type fixed from 'java.lang.Object' to match base method */
        @Override // kotlin.g.a.b
        public final /* synthetic */ x invoke(Object obj) {
            AppMethodBeat.i(162127);
            try {
                this.cPt.invoke(obj);
            } catch (Exception e2) {
                c.C0193c.printStackTrace("MagicBrush", e2, "dispatch failed", new Object[0]);
            }
            x xVar = x.SXb;
            AppMethodBeat.o(162127);
            return xVar;
        }
    }
}
