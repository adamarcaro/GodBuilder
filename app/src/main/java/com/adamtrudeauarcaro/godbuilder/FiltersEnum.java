package com.adamtrudeauarcaro.godbuilder;

/**
 * Created by adama on 2017-04-14.
 */

public enum FiltersEnum {

    RED(R.string.medusa_title, R.layout.filters_class),
    BLUE(R.string.anubis, R.layout.filters_pantheon);

    private int mTitleResId;
    private int mLayoutResId;

    FiltersEnum(int titleResId, int layoutResId) {
        mTitleResId = titleResId;
        mLayoutResId = layoutResId;
    }

    public int getTitleResId() {
        return mTitleResId;
    }

    public int getLayoutResId() {
        return mLayoutResId;
    }

}
