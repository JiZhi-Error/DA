package com.tencent.mm.plugin.topstory.ui.video;

import android.support.v4.e.o;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.tencent.mm.protocal.protobuf.eiw;
import com.tencent.mm.sdk.platformtools.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class e extends RecyclerView.a<h> {
    protected o<View> GlP = new o<>();
    protected o<View> GlQ = new o<>();
    public Map<String, WeakReference<h>> GlR = new HashMap();
    public b GlS;

    public e(b bVar) {
        this.GlS = bVar;
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemCount() {
        return this.GlS.fyO().fzy() + this.GlP.size() + this.GlQ.size();
    }

    public final int getHeadersCount() {
        return this.GlP.size();
    }

    public final int getFootersCount() {
        return this.GlQ.size();
    }

    @Override // android.support.v7.widget.RecyclerView.a
    public final int getItemViewType(int i2) {
        if (abZ(i2)) {
            return this.GlP.keyAt(i2);
        }
        if (aca(i2)) {
            return this.GlQ.keyAt((i2 - this.GlP.size()) - this.GlS.fyO().fzy());
        }
        return abY(i2);
    }

    public int abY(int i2) {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void t(List<eiw> list, boolean z) {
        Log.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "callbackToSuccess %d %b", Integer.valueOf(list.size()), Boolean.valueOf(z));
    }

    public final void addHeaderView(View view) {
        this.GlP.put(this.GlP.size() + 100000, view);
    }

    public final void fT(View view) {
        this.GlQ.put(this.GlQ.size() + 200000, view);
    }

    public final void fyU() {
        this.GlQ.clear();
    }

    public final h b(eiw eiw) {
        if (!(eiw == null || !this.GlR.containsKey(eiw.psI) || this.GlR.get(eiw.psI) == null)) {
            h hVar = this.GlR.get(eiw.psI).get();
            if (hVar != null && hVar.GjH != null && hVar.GjH == eiw) {
                return hVar;
            }
            this.GlR.remove(eiw.psI);
            Log.i("MicroMsg.TopStory.TopStoryBaseVideoAdapter", "getViewHolderByVideoInfo not match");
        }
        return null;
    }

    public final boolean abZ(int i2) {
        return i2 < this.GlP.size();
    }

    public final boolean aca(int i2) {
        return i2 >= this.GlP.size() + this.GlS.fyO().fzy();
    }
}
