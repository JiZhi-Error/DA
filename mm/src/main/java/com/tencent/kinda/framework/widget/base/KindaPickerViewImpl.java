package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.support.v4.content.b;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ui.aa;
import com.tencent.mm.ui.widget.picker.WheelView;
import com.tencent.mm.ui.widget.picker.a.a;
import com.tencent.mm.ui.widget.picker.d.c;
import java.util.ArrayList;
import java.util.List;

public class KindaPickerViewImpl<T> extends LinearLayout {
    private static final String TAG = "KindaPickerViewImpl";
    private boolean mIsLinkage = true;
    private List<T> mLeftWheelItems;
    private OnSelectChangeListener mOnSelectChangeListener;
    private List<? extends List<T>> mRightWheelItems;
    private WheelView mWheelViewLeft;
    private WheelView mWheelViewRight;

    /* access modifiers changed from: package-private */
    public interface OnSelectChangeListener {
        void onSelected(ArrayList<Integer> arrayList);
    }

    public KindaPickerViewImpl(Context context) {
        super(context);
        AppMethodBeat.i(214480);
        init(context);
        AppMethodBeat.o(214480);
    }

    public KindaPickerViewImpl(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(214481);
        init(context);
        AppMethodBeat.o(214481);
    }

    public KindaPickerViewImpl(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        AppMethodBeat.i(214482);
        init(context);
        AppMethodBeat.o(214482);
    }

    public KindaPickerViewImpl(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        AppMethodBeat.i(214483);
        init(context);
        AppMethodBeat.o(214483);
    }

    private void init(Context context) {
        AppMethodBeat.i(214484);
        aa.jQ(context).inflate(R.layout.axz, this);
        this.mWheelViewLeft = (WheelView) findViewById(R.id.g5a);
        this.mWheelViewRight = (WheelView) findViewById(R.id.g5b);
        setDividerHeight((float) context.getResources().getDimensionPixelSize(R.dimen.tv));
        setDividerColor(b.n(context, R.color.BW_0_Alpha_0_1));
        setPadding(0, context.getResources().getDimensionPixelSize(R.dimen.cb), 0, context.getResources().getDimensionPixelSize(R.dimen.cb));
        setItemHeight(context.getResources().getDimensionPixelSize(R.dimen.cb));
        setTextColor(b.n(context, R.color.BW_0_Alpha_0_9));
        setLoop(false);
        AppMethodBeat.o(214484);
    }

    public void setLinkagePicker(List<T> list, List<? extends List<T>> list2) {
        AppMethodBeat.i(214485);
        if (list == null) {
            AppMethodBeat.o(214485);
            return;
        }
        this.mLeftWheelItems = list;
        this.mRightWheelItems = list2;
        this.mIsLinkage = true;
        this.mWheelViewLeft.setAdapter(new a(this.mLeftWheelItems));
        this.mWheelViewLeft.setCurrentItem(0);
        if (this.mLeftWheelItems != null) {
            this.mWheelViewRight.setAdapter(new a((List) this.mRightWheelItems.get(0)));
        }
        this.mWheelViewRight.setCurrentItem(this.mWheelViewRight.getCurrentItem());
        if (list != null) {
            this.mWheelViewLeft.setOnItemSelectedListener(new c() {
                /* class com.tencent.kinda.framework.widget.base.KindaPickerViewImpl.AnonymousClass1 */

                @Override // com.tencent.mm.ui.widget.picker.d.c
                public void onItemSelected(int i2) {
                    AppMethodBeat.i(214476);
                    if (KindaPickerViewImpl.this.mOnSelectChangeListener == null) {
                        AppMethodBeat.o(214476);
                        return;
                    }
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(Integer.valueOf(i2));
                    arrayList.add(0);
                    if (KindaPickerViewImpl.this.mRightWheelItems != null) {
                        KindaPickerViewImpl.this.mWheelViewRight.setAdapter(new a((List) KindaPickerViewImpl.this.mRightWheelItems.get(i2)));
                        KindaPickerViewImpl.this.mWheelViewRight.setCurrentItem(0);
                    }
                    KindaPickerViewImpl.this.mOnSelectChangeListener.onSelected(arrayList);
                    AppMethodBeat.o(214476);
                }
            });
        }
        if (list2 != null) {
            this.mWheelViewRight.setOnItemSelectedListener(new c() {
                /* class com.tencent.kinda.framework.widget.base.KindaPickerViewImpl.AnonymousClass2 */

                @Override // com.tencent.mm.ui.widget.picker.d.c
                public void onItemSelected(int i2) {
                    AppMethodBeat.i(214477);
                    if (KindaPickerViewImpl.this.mOnSelectChangeListener == null) {
                        AppMethodBeat.o(214477);
                        return;
                    }
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(Integer.valueOf(KindaPickerViewImpl.this.mWheelViewLeft.getCurrentItem()));
                    arrayList.add(Integer.valueOf(i2));
                    KindaPickerViewImpl.this.mOnSelectChangeListener.onSelected(arrayList);
                    AppMethodBeat.o(214477);
                }
            });
        }
        AppMethodBeat.o(214485);
    }

    public void setIndividualPicker(List<? extends List<T>> list) {
        AppMethodBeat.i(214486);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(214486);
            return;
        }
        List list2 = (List) list.get(0);
        List list3 = null;
        if (list.size() > 1) {
            list3 = (List) list.get(1);
        }
        this.mIsLinkage = false;
        this.mWheelViewLeft.setAdapter(new a(list2));
        this.mWheelViewLeft.setCurrentItem(0);
        if (list3 != null) {
            this.mWheelViewRight.setAdapter(new a(list3));
        }
        this.mWheelViewRight.setCurrentItem(this.mWheelViewRight.getCurrentItem());
        this.mWheelViewLeft.setIsOptions(true);
        this.mWheelViewRight.setIsOptions(true);
        if (this.mOnSelectChangeListener == null) {
            AppMethodBeat.o(214486);
            return;
        }
        this.mWheelViewLeft.setOnItemSelectedListener(new c() {
            /* class com.tencent.kinda.framework.widget.base.KindaPickerViewImpl.AnonymousClass3 */

            @Override // com.tencent.mm.ui.widget.picker.d.c
            public void onItemSelected(int i2) {
                AppMethodBeat.i(214478);
                ArrayList<Integer> arrayList = new ArrayList<>();
                arrayList.add(Integer.valueOf(i2));
                arrayList.add(Integer.valueOf(KindaPickerViewImpl.this.mWheelViewRight.getCurrentItem()));
                if (KindaPickerViewImpl.this.mOnSelectChangeListener != null) {
                    KindaPickerViewImpl.this.mOnSelectChangeListener.onSelected(arrayList);
                }
                AppMethodBeat.o(214478);
            }
        });
        if (list3 != null) {
            this.mWheelViewRight.setOnItemSelectedListener(new c() {
                /* class com.tencent.kinda.framework.widget.base.KindaPickerViewImpl.AnonymousClass4 */

                @Override // com.tencent.mm.ui.widget.picker.d.c
                public void onItemSelected(int i2) {
                    AppMethodBeat.i(214479);
                    ArrayList<Integer> arrayList = new ArrayList<>();
                    arrayList.add(Integer.valueOf(KindaPickerViewImpl.this.mWheelViewLeft.getCurrentItem()));
                    arrayList.add(Integer.valueOf(i2));
                    if (KindaPickerViewImpl.this.mOnSelectChangeListener != null) {
                        KindaPickerViewImpl.this.mOnSelectChangeListener.onSelected(arrayList);
                    }
                    AppMethodBeat.o(214479);
                }
            });
        }
        AppMethodBeat.o(214486);
    }

    public ArrayList<Integer> getCurrentItems() {
        int i2;
        AppMethodBeat.i(214487);
        ArrayList<Integer> arrayList = new ArrayList<>();
        int currentItem = this.mWheelViewLeft.getCurrentItem();
        int currentItem2 = this.mWheelViewRight.getCurrentItem();
        if (this.mRightWheelItems != null && this.mRightWheelItems.size() > 0) {
            if (currentItem2 > ((List) this.mRightWheelItems.get(currentItem)).size() - 1) {
                i2 = 0;
            } else {
                i2 = currentItem2;
            }
            currentItem2 = i2;
        }
        arrayList.add(Integer.valueOf(currentItem));
        arrayList.add(Integer.valueOf(currentItem2));
        AppMethodBeat.o(214487);
        return arrayList;
    }

    public void setCurrentItems(List<Integer> list) {
        AppMethodBeat.i(214488);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(214488);
        } else if (this.mIsLinkage) {
            forceSetSelectedItems(list);
            AppMethodBeat.o(214488);
        } else {
            this.mWheelViewLeft.setCurrentItem(list.get(0).intValue());
            if (list.size() > 1) {
                this.mWheelViewRight.setCurrentItem(list.get(1).intValue());
            }
            AppMethodBeat.o(214488);
        }
    }

    public void setOnSelectChangeListener(OnSelectChangeListener onSelectChangeListener) {
        this.mOnSelectChangeListener = onSelectChangeListener;
    }

    public void setTextColor(int i2) {
        AppMethodBeat.i(214489);
        this.mWheelViewLeft.aps(i2);
        this.mWheelViewRight.aps(i2);
        AppMethodBeat.o(214489);
    }

    public void setItemHeight(int i2) {
        AppMethodBeat.i(214490);
        this.mWheelViewLeft.apr(i2);
        this.mWheelViewRight.apr(i2);
        AppMethodBeat.o(214490);
    }

    public void setLoop(boolean z) {
        AppMethodBeat.i(214491);
        this.mWheelViewLeft.setCyclic(z);
        this.mWheelViewRight.setCyclic(z);
        AppMethodBeat.o(214491);
    }

    public void setDividerHeight(float f2) {
        AppMethodBeat.i(214492);
        this.mWheelViewLeft.setDividerHeight(f2);
        this.mWheelViewRight.setDividerHeight(f2);
        AppMethodBeat.o(214492);
    }

    public void setDividerColor(int i2) {
        AppMethodBeat.i(214493);
        this.mWheelViewLeft.setDividerColor(i2);
        this.mWheelViewRight.setDividerColor(i2);
        AppMethodBeat.o(214493);
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        AppMethodBeat.i(214494);
        this.mWheelViewLeft.setPadding(i2, i3, i4, i5);
        this.mWheelViewRight.setPadding(i2, i3, i4, i5);
        AppMethodBeat.o(214494);
    }

    private void forceSetSelectedItems(List<Integer> list) {
        AppMethodBeat.i(214495);
        if (list == null || list.size() <= 0) {
            AppMethodBeat.o(214495);
            return;
        }
        if (this.mLeftWheelItems != null) {
            this.mWheelViewLeft.setCurrentItem(list.get(0).intValue());
        }
        if (this.mRightWheelItems != null && list.size() > 1) {
            this.mWheelViewRight.setAdapter(new a((List) this.mRightWheelItems.get(list.get(0).intValue())));
            this.mWheelViewRight.setCurrentItem(list.get(1).intValue());
        }
        AppMethodBeat.o(214495);
    }
}
