package com.tencent.mm.live.c;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Display;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.tencent.mm.live.c.b;
import java.util.LinkedHashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(hxD = {1, 1, 16}, hxE = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J$\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\fH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\"\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\f2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J4\u0010\u001f\u001a\u00020\n2\"\u0010 \u001a\u001e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\"0!j\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\"`#2\u0006\u0010$\u001a\u00020\u0013H\u0016J\b\u0010%\u001a\u00020\u0013H\u0016J\b\u0010&\u001a\u00020\nH\u0016J\b\u0010'\u001a\u00020\nH\u0016J\u0010\u0010(\u001a\u00020\n2\u0006\u0010)\u001a\u00020\fH\u0016J\b\u0010*\u001a\u00020\nH\u0016J\u001a\u0010+\u001a\u00020\n2\u0006\u0010,\u001a\u00020-2\b\u0010.\u001a\u0004\u0018\u00010\u000fH\u0016J\b\u0010/\u001a\u00020\nH\u0016J\b\u00100\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u00061"}, hxF = {"Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Lcom/tencent/mm/live/view/ILivePlugin;", "root", "Landroid/view/ViewGroup;", "broadcast", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "getRoot", "()Landroid/view/ViewGroup;", "applyState", "", "liveState", "", "uiState", "extraMsg", "Landroid/os/Bundle;", "getCurrentOrientation", "getVisible", "isLandscape", "", "keyboardChange", "show", "height", "mount", "name", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAudienceMicUserChanged", "micUserMap", "Ljava/util/LinkedHashMap;", "Landroid/graphics/Rect;", "Lkotlin/collections/LinkedHashMap;", "isPkAnchor", "onBackPress", "pause", "resume", "setVisible", "visible", "start", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "stop", "unMount", "plugin-logic_release"})
public abstract class a implements com.tencent.mm.live.view.a {
    public final ViewGroup hwr;

    public a(ViewGroup viewGroup, b bVar) {
        p.h(viewGroup, "root");
        p.h(bVar, "broadcast");
        this.hwr = viewGroup;
        bVar.registerPlugin(this);
    }

    public void mount() {
    }

    public void resume() {
    }

    public void pause() {
    }

    public void unMount() {
    }

    public boolean onBackPress() {
        return false;
    }

    public void keyboardChange(boolean z, int i2) {
    }

    public void statusChange(b.c cVar, Bundle bundle) {
        p.h(cVar, "status");
    }

    public void B(int i2, Bundle bundle) {
    }

    public void rg(int i2) {
        this.hwr.setVisibility(i2);
    }

    public void a(LinkedHashMap<String, Rect> linkedHashMap, boolean z) {
        p.h(linkedHashMap, "micUserMap");
    }

    @Override // com.tencent.mm.live.view.a
    public String name() {
        String simpleName = getClass().getSimpleName();
        p.g(simpleName, "this.javaClass.simpleName");
        return simpleName;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
    }

    public final boolean isLandscape() {
        Context context = this.hwr.getContext();
        p.g(context, "root.context");
        Resources resources = context.getResources();
        p.g(resources, "root.context.resources");
        return resources.getConfiguration().orientation == 2;
    }

    public final int getCurrentOrientation() {
        Context context = this.hwr.getContext();
        if (context == null) {
            throw new t("null cannot be cast to non-null type android.app.Activity");
        }
        Window window = ((Activity) context).getWindow();
        p.g(window, "(root.context as Activity).window");
        WindowManager windowManager = window.getWindowManager();
        p.g(windowManager, "(root.context as Activity).window.windowManager");
        Display defaultDisplay = windowManager.getDefaultDisplay();
        p.g(defaultDisplay, "(root.context as Activit…dowManager.defaultDisplay");
        return defaultDisplay.getRotation();
    }
}
