package com.google.android.gms.dynamic;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import com.google.android.gms.dynamic.IFragmentWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;

public final class SupportFragmentWrapper extends IFragmentWrapper.Stub {
    private byte _hellAccFlag_;
    private Fragment zzabq;

    private SupportFragmentWrapper(Fragment fragment) {
        this.zzabq = fragment;
    }

    public static SupportFragmentWrapper wrap(Fragment fragment) {
        AppMethodBeat.i(5419);
        if (fragment != null) {
            SupportFragmentWrapper supportFragmentWrapper = new SupportFragmentWrapper(fragment);
            AppMethodBeat.o(5419);
            return supportFragmentWrapper;
        }
        AppMethodBeat.o(5419);
        return null;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper getActivity() {
        AppMethodBeat.i(5420);
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zzabq.getActivity());
        AppMethodBeat.o(5420);
        return wrap;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final Bundle getArguments() {
        AppMethodBeat.i(5421);
        Bundle arguments = this.zzabq.getArguments();
        AppMethodBeat.o(5421);
        return arguments;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int getId() {
        AppMethodBeat.i(5422);
        int id = this.zzabq.getId();
        AppMethodBeat.o(5422);
        return id;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper getParentFragment() {
        AppMethodBeat.i(5423);
        SupportFragmentWrapper wrap = wrap(this.zzabq.getParentFragment());
        AppMethodBeat.o(5423);
        return wrap;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper getResources() {
        AppMethodBeat.i(5424);
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zzabq.getResources());
        AppMethodBeat.o(5424);
        return wrap;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean getRetainInstance() {
        AppMethodBeat.i(5425);
        boolean retainInstance = this.zzabq.getRetainInstance();
        AppMethodBeat.o(5425);
        return retainInstance;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final String getTag() {
        AppMethodBeat.i(5426);
        String tag = this.zzabq.getTag();
        AppMethodBeat.o(5426);
        return tag;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper getTargetFragment() {
        AppMethodBeat.i(5427);
        SupportFragmentWrapper wrap = wrap(this.zzabq.getTargetFragment());
        AppMethodBeat.o(5427);
        return wrap;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int getTargetRequestCode() {
        AppMethodBeat.i(5428);
        int targetRequestCode = this.zzabq.getTargetRequestCode();
        AppMethodBeat.o(5428);
        return targetRequestCode;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean getUserVisibleHint() {
        AppMethodBeat.i(5429);
        boolean userVisibleHint = this.zzabq.getUserVisibleHint();
        AppMethodBeat.o(5429);
        return userVisibleHint;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper getView() {
        AppMethodBeat.i(5430);
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zzabq.getView());
        AppMethodBeat.o(5430);
        return wrap;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isAdded() {
        AppMethodBeat.i(5431);
        boolean isAdded = this.zzabq.isAdded();
        AppMethodBeat.o(5431);
        return isAdded;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isDetached() {
        AppMethodBeat.i(5432);
        boolean isDetached = this.zzabq.isDetached();
        AppMethodBeat.o(5432);
        return isDetached;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isHidden() {
        AppMethodBeat.i(5433);
        boolean isHidden = this.zzabq.isHidden();
        AppMethodBeat.o(5433);
        return isHidden;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isInLayout() {
        AppMethodBeat.i(5434);
        boolean isInLayout = this.zzabq.isInLayout();
        AppMethodBeat.o(5434);
        return isInLayout;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isRemoving() {
        AppMethodBeat.i(5435);
        boolean isRemoving = this.zzabq.isRemoving();
        AppMethodBeat.o(5435);
        return isRemoving;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isResumed() {
        AppMethodBeat.i(5436);
        boolean isResumed = this.zzabq.isResumed();
        AppMethodBeat.o(5436);
        return isResumed;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isVisible() {
        AppMethodBeat.i(5437);
        boolean isVisible = this.zzabq.isVisible();
        AppMethodBeat.o(5437);
        return isVisible;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void registerForContextMenu(IObjectWrapper iObjectWrapper) {
        AppMethodBeat.i(5438);
        this.zzabq.registerForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
        AppMethodBeat.o(5438);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void setHasOptionsMenu(boolean z) {
        AppMethodBeat.i(5439);
        this.zzabq.setHasOptionsMenu(z);
        AppMethodBeat.o(5439);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void setMenuVisibility(boolean z) {
        AppMethodBeat.i(5440);
        this.zzabq.setMenuVisibility(z);
        AppMethodBeat.o(5440);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void setRetainInstance(boolean z) {
        AppMethodBeat.i(5441);
        this.zzabq.setRetainInstance(z);
        AppMethodBeat.o(5441);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void setUserVisibleHint(boolean z) {
        AppMethodBeat.i(5442);
        this.zzabq.setUserVisibleHint(z);
        AppMethodBeat.o(5442);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void startActivity(Intent intent) {
        AppMethodBeat.i(5443);
        Fragment fragment = this.zzabq;
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(fragment, bl.axQ(), "com/google/android/gms/dynamic/SupportFragmentWrapper", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        fragment.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(fragment, "com/google/android/gms/dynamic/SupportFragmentWrapper", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(5443);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void startActivityForResult(Intent intent, int i2) {
        AppMethodBeat.i(5444);
        this.zzabq.startActivityForResult(intent, i2);
        AppMethodBeat.o(5444);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void unregisterForContextMenu(IObjectWrapper iObjectWrapper) {
        AppMethodBeat.i(5445);
        this.zzabq.unregisterForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
        AppMethodBeat.o(5445);
    }
}
