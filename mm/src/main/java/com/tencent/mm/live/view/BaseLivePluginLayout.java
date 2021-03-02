package com.tencent.mm.live.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import com.tencent.mm.live.api.LiveConfig;
import com.tencent.mm.live.b.j;
import com.tencent.mm.live.c.a;
import com.tencent.mm.live.c.b;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004B\u0017\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H&J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH&J\b\u0010\u001f\u001a\u00020\u001eH\u0016J\u0018\u0010 \u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0017H\u0016J\b\u0010#\u001a\u00020\u001aH\u0016J\"\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00172\u0006\u0010&\u001a\u00020\u00172\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u001eH\u0016J\u0018\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020\u00172\u0006\u0010,\u001a\u00020-H&J\u0010\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u001eH&J\b\u00100\u001a\u00020\u001aH\u0016J\u0012\u00101\u001a\u00020\u001a2\b\u00102\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u00103\u001a\u00020\u001aH\u0016J\b\u00104\u001a\u00020\u001aH\u0016J\u001a\u00105\u001a\u00020\u001a2\u0006\u00106\u001a\u0002072\b\u00108\u001a\u0004\u0018\u000109H\u0016J\b\u0010:\u001a\u00020\u001aH\u0016J\b\u0010;\u001a\u00020\u001aH\u0016R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR$\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\u00120\u0011j\b\u0012\u0004\u0012\u00020\u0012`\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006<"}, hxF = {"Lcom/tencent/mm/live/view/BaseLivePluginLayout;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/mm/live/view/ILivePlugin;", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "Lcom/tencent/mm/live/model/ILiveSysMsgNotifier;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "parent", "Landroid/view/ViewGroup;", "getParent", "()Landroid/view/ViewGroup;", "setParent", "(Landroid/view/ViewGroup;)V", "pluginList", "Ljava/util/ArrayList;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lkotlin/collections/ArrayList;", "getPluginList", "()Ljava/util/ArrayList;", "getCurrentOrientation", "", "getRelativeLayoutId", "initLogic", "", "config", "Lcom/tencent/mm/live/api/LiveConfig;", "isFinished", "", "isLandscape", "keyboardChange", "show", "height", "mount", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPress", "onCallStateChanged", "state", "incomingNumber", "", "onRotationSwitchChange", "rotationEnable", "pause", "registerPlugin", "plugin", "resume", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "stop", "unMount", "plugin-logic_release"})
public abstract class BaseLivePluginLayout extends RelativeLayout implements j, b, a {
    private ViewGroup parent;
    private final ArrayList<a> pluginList = new ArrayList<>();

    public abstract int getRelativeLayoutId();

    public abstract void initLogic(LiveConfig liveConfig, boolean z);

    public abstract void onCallStateChanged(int i2, String str);

    public abstract void onRotationSwitchChange(boolean z);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseLivePluginLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        p.h(context, "context");
        View inflate = LayoutInflater.from(context).inflate(getRelativeLayoutId(), (ViewGroup) this, true);
        if (inflate == null) {
            throw new t("null cannot be cast to non-null type android.view.ViewGroup");
        }
        this.parent = (ViewGroup) inflate;
    }

    public final ArrayList<a> getPluginList() {
        return this.pluginList;
    }

    public final ViewGroup getParent() {
        return this.parent;
    }

    /* access modifiers changed from: protected */
    public final void setParent(ViewGroup viewGroup) {
        p.h(viewGroup, "<set-?>");
        this.parent = viewGroup;
    }

    public void mount() {
        Iterator<T> it = this.pluginList.iterator();
        while (it.hasNext()) {
            it.next().mount();
        }
    }

    public void resume() {
        setVisibility(0);
        Iterator<T> it = this.pluginList.iterator();
        while (it.hasNext()) {
            it.next().resume();
        }
    }

    public void start() {
        Iterator<T> it = this.pluginList.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public void pause() {
        Iterator<T> it = this.pluginList.iterator();
        while (it.hasNext()) {
            it.next().pause();
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Iterator<T> it = this.pluginList.iterator();
        while (it.hasNext()) {
            it.next().onActivityResult(i2, i3, intent);
        }
    }

    public void stop() {
        Iterator<T> it = this.pluginList.iterator();
        while (it.hasNext()) {
            it.next();
        }
    }

    public void unMount() {
        Iterator<T> it = this.pluginList.iterator();
        while (it.hasNext()) {
            it.next().unMount();
        }
    }

    public boolean onBackPress() {
        for (T t : this.pluginList) {
            if (t.onBackPress()) {
                Log.i(name(), t.name() + " handle back-press");
                return true;
            }
        }
        return false;
    }

    @Override // com.tencent.mm.live.c.b
    public void registerPlugin(a aVar) {
        if (aVar != null) {
            Log.i(name(), "register plugin " + aVar.name());
            this.pluginList.add(aVar);
        }
    }

    @Override // com.tencent.mm.live.c.b
    public void statusChange(b.c cVar, Bundle bundle) {
        p.h(cVar, "status");
        Iterator<T> it = this.pluginList.iterator();
        while (it.hasNext()) {
            it.next().statusChange(cVar, bundle);
        }
    }

    public void keyboardChange(boolean z, int i2) {
        Iterator<T> it = this.pluginList.iterator();
        while (it.hasNext()) {
            it.next().keyboardChange(z, i2);
        }
    }

    public boolean isLandscape() {
        Context context = getContext();
        p.g(context, "context");
        Resources resources = context.getResources();
        p.g(resources, "context.resources");
        return resources.getConfiguration().orientation == 2;
    }

    public int getCurrentOrientation() {
        Context context = getContext();
        if (context == null) {
            throw new t("null cannot be cast to non-null type android.app.Activity");
        }
        Window window = ((Activity) context).getWindow();
        p.g(window, "(context as Activity).window");
        WindowManager windowManager = window.getWindowManager();
        p.g(windowManager, "(context as Activity).window.windowManager");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        p.g(defaultDisplay, "(context as Activity).wi…dowManager.defaultDisplay");
        return defaultDisplay.getRotation();
    }
}
