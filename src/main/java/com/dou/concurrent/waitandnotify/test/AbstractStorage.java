package com.dou.concurrent.waitandnotify.test;

public interface AbstractStorage {
    void consume(int num);
    void produce(int num);
}
