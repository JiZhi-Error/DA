package com.tencent.mm.emoji.loader.e;

import com.facebook.share.internal.ShareConstants;
import com.tencent.mm.emoji.loader.d.i;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD = {1, 1, 16}, hxE = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\b&\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\fJ\b\u0010\u0016\u001a\u00020\u0014H\u0016J\b\u0010\u0017\u001a\u00020\u0018H&J\u0010\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\tH\u0016J\u0012\u0010\u001b\u001a\u00020\u00142\n\u0010\u0015\u001a\u0006\u0012\u0002\b\u00030\fJ\b\u0010\u001c\u001a\u00020\u0014H\u0016J\u0012\u0010\u001d\u001a\u00020\u00142\b\b\u0002\u0010\u001e\u001a\u00020\tH\u0016J\b\u0010\u001f\u001a\u00020\u0018H\u0016R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000RB\u0010\n\u001a6\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \r*\b\u0012\u0002\b\u0003\u0018\u00010\f0\f \r*\u001a\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \r*\b\u0012\u0002\b\u0003\u0018\u00010\f0\f\u0018\u00010\u000e0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, hxF = {"Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "Ljava/lang/Runnable;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getEmojiInfo", "()Lcom/tencent/mm/storage/emotion/EmojiInfo;", "finished", "", "requests", "", "Lcom/tencent/mm/emoji/loader/request/Request;", "kotlin.jvm.PlatformType", "", "result", "running", "runningInQueue", "started", "addRequest", "", ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, "call", "getTaskKey", "", "onResult", "success", "removeRequest", "run", "start", "async", "uniqueId", "plugin-emojisdk_release"})
public abstract class c extends com.tencent.mm.loader.g.c implements Runnable {
    private boolean chA;
    private boolean gWO;
    final EmojiInfo gWm;
    private final List<i<?>> requests = Collections.synchronizedList(new LinkedList());
    private boolean result;
    private boolean running;
    private boolean started;

    public abstract String auJ();

    public c(EmojiInfo emojiInfo) {
        p.h(emojiInfo, "emojiInfo");
        this.gWm = emojiInfo;
    }

    @Override // com.tencent.mm.loader.g.c
    public final String auK() {
        return auJ();
    }

    @Override // com.tencent.mm.loader.g.c
    public final void call() {
        this.gWO = true;
        run();
    }

    public final void start(boolean z) {
        if (!this.started) {
            this.started = true;
            e eVar = e.gVM;
            e.a(auJ(), this, z);
        }
    }

    public void run() {
        this.running = true;
    }

    public final void c(i<?> iVar) {
        p.h(iVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        if (this.chA) {
            iVar.dR(this.result);
        } else if (!this.requests.contains(iVar)) {
            this.requests.add(iVar);
        }
    }

    public final void d(i<?> iVar) {
        p.h(iVar, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        this.requests.remove(iVar);
        if (this.requests.size() == 0) {
            Log.d(d.auD(), "cancel " + auJ() + ", " + this.running);
            if (!this.running) {
                e eVar = e.gVM;
                e.EN(auJ());
                dQ(false);
            }
        }
    }

    public void dQ(boolean z) {
        this.result = z;
        this.chA = true;
        if (this.gWO) {
            a(j.OK);
        } else {
            e eVar = e.gVM;
            e.EN(auJ());
        }
        LinkedList<i> linkedList = new LinkedList();
        List<i<?>> list = this.requests;
        p.g(list, "requests");
        synchronized (list) {
            linkedList.addAll(this.requests);
            this.requests.clear();
            x xVar = x.SXb;
        }
        for (i iVar : linkedList) {
            iVar.dR(z);
        }
    }
}
