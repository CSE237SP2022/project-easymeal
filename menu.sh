#!/bin/bash
# CSE237 EasyMeal Project

cd src/ || return
javac menu/MenuItem.java cart/UserCart.java main/MainMethod.java
java main/MainMethod