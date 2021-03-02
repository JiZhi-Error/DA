package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import com.tencent.kinda.framework.widget.base.KindaPickerViewImpl;
import com.tencent.kinda.gen.KPickerView;
import com.tencent.kinda.gen.VoidListCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public class MMKPickerView extends MMKView<KindaPickerViewImpl<String>> implements KPickerView {
    /* Return type fixed from 'com.tencent.kinda.framework.widget.base.KindaPickerViewImpl' to match base method */
    @Override // com.tencent.kinda.framework.widget.base.MMKView
    public KindaPickerViewImpl<String> createView(Context context) {
        AppMethodBeat.i(214540);
        this.view = new KindaPickerViewImpl(context);
        KindaPickerViewImpl kindaPickerViewImpl = (KindaPickerViewImpl) this.view;
        AppMethodBeat.o(214540);
        return kindaPickerViewImpl;
    }

    @Override // com.tencent.kinda.gen.KPickerView
    public void setNormalData(ArrayList<ArrayList<String>> arrayList) {
        AppMethodBeat.i(214541);
        if (arrayList == null) {
            AppMethodBeat.o(214541);
            return;
        }
        ((KindaPickerViewImpl) this.view).setIndividualPicker(arrayList);
        AppMethodBeat.o(214541);
    }

    @Override // com.tencent.kinda.gen.KPickerView
    public void setSyncData(ArrayList<String> arrayList, ArrayList<ArrayList<String>> arrayList2) {
        AppMethodBeat.i(214542);
        ((KindaPickerViewImpl) this.view).setLinkagePicker(arrayList, arrayList2);
        AppMethodBeat.o(214542);
    }

    @Override // com.tencent.kinda.gen.KPickerView
    public void setCallbackImpl(final VoidListCallback voidListCallback) {
        AppMethodBeat.i(214543);
        ((KindaPickerViewImpl) this.view).setOnSelectChangeListener(new KindaPickerViewImpl.OnSelectChangeListener() {
            /* class com.tencent.kinda.framework.widget.base.MMKPickerView.AnonymousClass1 */

            @Override // com.tencent.kinda.framework.widget.base.KindaPickerViewImpl.OnSelectChangeListener
            public void onSelected(ArrayList<Integer> arrayList) {
                AppMethodBeat.i(214539);
                if (voidListCallback != null) {
                    voidListCallback.call(arrayList);
                }
                AppMethodBeat.o(214539);
            }
        });
        AppMethodBeat.o(214543);
    }

    @Override // com.tencent.kinda.gen.KPickerView
    public ArrayList<Integer> getCurrentSelectedRows() {
        AppMethodBeat.i(214544);
        ArrayList<Integer> currentItems = ((KindaPickerViewImpl) this.view).getCurrentItems();
        AppMethodBeat.o(214544);
        return currentItems;
    }

    @Override // com.tencent.kinda.gen.KPickerView
    public void setSelectedRows(ArrayList<Integer> arrayList) {
        AppMethodBeat.i(214545);
        ((KindaPickerViewImpl) this.view).setCurrentItems(arrayList);
        AppMethodBeat.o(214545);
    }
}
