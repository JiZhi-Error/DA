package com.tencent.mm.plugin.finder.feed.model.internal;

import com.facebook.share.internal.ShareConstants;
import com.tencent.mm.plugin.finder.feed.model.internal.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.sharp.jni.QLog;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 \u0016*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003:\u0001\u0016B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\fH\u0016J \u0010\u000e\u001a\u00020\f2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00032\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H&J\u0016\u0010\u0013\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H&J\u0016\u0010\u0014\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H\u0016J\u0016\u0010\u0015\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00000\u0011H&R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0017"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch;", QLog.TAG_REPORTLEVEL_DEVELOPER, "Lcom/tencent/mm/plugin/finder/feed/model/internal/ILoaderData;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "alive", "", "dead", "fetch", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "callback", "Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataCallback;", "fetchInit", "fetchLoadMore", "fetchPreload", "fetchRefresh", "Companion", "plugin-finder_release"})
public abstract class g<D extends i> {
    public static final a Companion = new a((byte) 0);
    private static final boolean DEBUG = false;
    private String TAG;

    public abstract void fetchInit(f<D> fVar);

    public abstract void fetchLoadMore(f<D> fVar);

    public abstract void fetchRefresh(f<D> fVar);

    public g() {
        StringBuilder sb = new StringBuilder("Finder.");
        String simpleName = getClass().getSimpleName();
        this.TAG = sb.append(simpleName == null ? "IDataFetch" : simpleName).append('_').append(hashCode()).toString();
    }

    public String getTAG() {
        return this.TAG;
    }

    public void setTAG(String str) {
        p.h(str, "<set-?>");
        this.TAG = str;
    }

    @l(hxD = {1, 1, 16}, hxE = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, hxF = {"Lcom/tencent/mm/plugin/finder/feed/model/internal/IDataFetch$Companion;", "", "()V", "DEBUG", "", "getDEBUG", "()Z", "plugin-finder_release"})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    public void alive() {
        Log.i(getTAG(), "alive.");
    }

    public void dead() {
        Log.i(getTAG(), "dead.");
    }

    public void fetchPreload(f<D> fVar) {
        p.h(fVar, "callback");
    }

    public void fetch(Object obj, f<D> fVar) {
        p.h(fVar, "callback");
    }
}
