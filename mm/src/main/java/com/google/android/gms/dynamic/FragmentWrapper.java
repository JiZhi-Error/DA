package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.dynamic.IFragmentWrapper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.a;

@SuppressLint({"NewApi"})
public final class FragmentWrapper extends IFragmentWrapper.Stub {
    private byte _hellAccFlag_;
    private Fragment zzabm;

    private FragmentWrapper(Fragment fragment) {
        this.zzabm = fragment;
    }

    public static FragmentWrapper wrap(Fragment fragment) {
        AppMethodBeat.i(5363);
        if (fragment != null) {
            FragmentWrapper fragmentWrapper = new FragmentWrapper(fragment);
            AppMethodBeat.o(5363);
            return fragmentWrapper;
        }
        AppMethodBeat.o(5363);
        return null;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper getActivity() {
        AppMethodBeat.i(5364);
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zzabm.getActivity());
        AppMethodBeat.o(5364);
        return wrap;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final Bundle getArguments() {
        AppMethodBeat.i(5365);
        Bundle arguments = this.zzabm.getArguments();
        AppMethodBeat.o(5365);
        return arguments;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int getId() {
        AppMethodBeat.i(5366);
        int id = this.zzabm.getId();
        AppMethodBeat.o(5366);
        return id;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper getParentFragment() {
        AppMethodBeat.i(5367);
        FragmentWrapper wrap = wrap(this.zzabm.getParentFragment());
        AppMethodBeat.o(5367);
        return wrap;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper getResources() {
        AppMethodBeat.i(5368);
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zzabm.getResources());
        AppMethodBeat.o(5368);
        return wrap;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean getRetainInstance() {
        AppMethodBeat.i(5369);
        boolean retainInstance = this.zzabm.getRetainInstance();
        AppMethodBeat.o(5369);
        return retainInstance;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final String getTag() {
        AppMethodBeat.i(5370);
        String tag = this.zzabm.getTag();
        AppMethodBeat.o(5370);
        return tag;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IFragmentWrapper getTargetFragment() {
        AppMethodBeat.i(5371);
        FragmentWrapper wrap = wrap(this.zzabm.getTargetFragment());
        AppMethodBeat.o(5371);
        return wrap;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final int getTargetRequestCode() {
        AppMethodBeat.i(5372);
        int targetRequestCode = this.zzabm.getTargetRequestCode();
        AppMethodBeat.o(5372);
        return targetRequestCode;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean getUserVisibleHint() {
        AppMethodBeat.i(5373);
        boolean userVisibleHint = this.zzabm.getUserVisibleHint();
        AppMethodBeat.o(5373);
        return userVisibleHint;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final IObjectWrapper getView() {
        AppMethodBeat.i(5374);
        IObjectWrapper wrap = ObjectWrapper.wrap(this.zzabm.getView());
        AppMethodBeat.o(5374);
        return wrap;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isAdded() {
        AppMethodBeat.i(5375);
        boolean isAdded = this.zzabm.isAdded();
        AppMethodBeat.o(5375);
        return isAdded;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isDetached() {
        AppMethodBeat.i(5376);
        boolean isDetached = this.zzabm.isDetached();
        AppMethodBeat.o(5376);
        return isDetached;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isHidden() {
        AppMethodBeat.i(5377);
        boolean isHidden = this.zzabm.isHidden();
        AppMethodBeat.o(5377);
        return isHidden;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isInLayout() {
        AppMethodBeat.i(5378);
        boolean isInLayout = this.zzabm.isInLayout();
        AppMethodBeat.o(5378);
        return isInLayout;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isRemoving() {
        AppMethodBeat.i(5379);
        boolean isRemoving = this.zzabm.isRemoving();
        AppMethodBeat.o(5379);
        return isRemoving;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isResumed() {
        AppMethodBeat.i(5380);
        boolean isResumed = this.zzabm.isResumed();
        AppMethodBeat.o(5380);
        return isResumed;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final boolean isVisible() {
        AppMethodBeat.i(5381);
        boolean isVisible = this.zzabm.isVisible();
        AppMethodBeat.o(5381);
        return isVisible;
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void registerForContextMenu(IObjectWrapper iObjectWrapper) {
        AppMethodBeat.i(5382);
        this.zzabm.registerForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
        AppMethodBeat.o(5382);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void setHasOptionsMenu(boolean z) {
        AppMethodBeat.i(5383);
        this.zzabm.setHasOptionsMenu(z);
        AppMethodBeat.o(5383);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void setMenuVisibility(boolean z) {
        AppMethodBeat.i(5384);
        this.zzabm.setMenuVisibility(z);
        AppMethodBeat.o(5384);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void setRetainInstance(boolean z) {
        AppMethodBeat.i(5385);
        this.zzabm.setRetainInstance(z);
        AppMethodBeat.o(5385);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void setUserVisibleHint(boolean z) {
        AppMethodBeat.i(5386);
        this.zzabm.setUserVisibleHint(z);
        AppMethodBeat.o(5386);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void startActivity(Intent intent) {
        AppMethodBeat.i(5387);
        Fragment fragment = this.zzabm;
        a bl = new a().bl(intent);
        com.tencent.mm.hellhoundlib.a.a.a(fragment, bl.axQ(), "com/google/android/gms/dynamic/FragmentWrapper", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        fragment.startActivity((Intent) bl.pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(fragment, "com/google/android/gms/dynamic/FragmentWrapper", "startActivity", "(Landroid/content/Intent;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(5387);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void startActivityForResult(Intent intent, int i2) {
        AppMethodBeat.i(5388);
        this.zzabm.startActivityForResult(intent, i2);
        AppMethodBeat.o(5388);
    }

    @Override // com.google.android.gms.dynamic.IFragmentWrapper
    public final void unregisterForContextMenu(IObjectWrapper iObjectWrapper) {
        AppMethodBeat.i(5389);
        this.zzabm.unregisterForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
        AppMethodBeat.o(5389);
    }
}
