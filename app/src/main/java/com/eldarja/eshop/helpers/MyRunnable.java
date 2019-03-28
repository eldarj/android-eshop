package com.eldarja.eshop.helpers;

import java.io.Serializable;

public interface MyRunnable<T> extends Serializable {
    void run(T t);
}
