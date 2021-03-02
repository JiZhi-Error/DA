package com.tencent.mm.plugin.finder.storage.config;

import android.app.Activity;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD = {1, 1, 16}, hxE = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00030\u0015H\u0016J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0006H&J\b\u0010\u0019\u001a\u00020\u0017H&J\u0010\u0010\u001a\u001a\u00020\u00172\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\b\u0010\u001b\u001a\u00020\u0003H&J\b\u0010\u001c\u001a\u00020\u0003H&R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0004¨\u0006\u001d"}, hxF = {"Lcom/tencent/mm/plugin/finder/storage/config/IFinderFakeConfig;", "", "title", "", "(Ljava/lang/String;)V", "chosenIndex", "", "getChosenIndex", "()I", "setChosenIndex", "(I)V", "context", "Landroid/app/Activity;", "getContext", "()Landroid/app/Activity;", "setContext", "(Landroid/app/Activity;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "itemNameList", "", "onItemClick", "", FirebaseAnalytics.b.INDEX, "reset", "setActivityContext", "svrValue", "versionTag", "plugin-finder_release"})
public abstract class e {
    public Activity dKq;
    public String title;
    public int vFI = -1;

    public abstract void Lc(int i2);

    public abstract String dyp();

    public abstract String dyq();

    public e(String str) {
        p.h(str, "title");
        this.title = str;
    }

    public List<String> dyo() {
        return new LinkedList();
    }
}
