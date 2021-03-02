package com.tencent.tencentmap.mapsdk.maps.interfaces;

public interface Selectable {

    public interface OnSelectedListener<T> {
        void onSelected(T t);
    }

    boolean isSelected();

    void setSelected(boolean z);

    <T> void setSelectedListener(OnSelectedListener<T> onSelectedListener);
}
