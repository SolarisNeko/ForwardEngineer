# Forward Engineer 正向工程

License = **Apache 2.0**

**current-version = v0.0.3**

当前版本 = v0.0.3

> @author: SolarisNeko 
>
> @startDate: Saturday，03/07/2021

## 示意图

![ForwardEngineer 正向工程](README.assets/ForwardEngineer 正向工程.png)

# 进度

## 1、目前进度

1. 使用 **@Table、@Column** 生成 [细粒度的建表SQL] 。
2. 单个 **class** + 递归扫描 **package**，生成 sql 。
3. 已加入对 **原生 Pojo** 的 `无侵入支持`

## 2、未来计划

2. 导出 sql 脚本到 **xxx.sql** 文件中。
2. 加入 **@Constraint** 支持 。
3. 加入对 **@Index** 支持。



------

# 介绍

## 1、preface 前言

​	Author still learning, is a Rookie.

​	Give me some issue make me think it is cool .

> 作者是一个菜鸟，还在学习。
>
> 开源，希望大家给我一些很 cool 的建议~

## 2、Origin Intention 初衷

### 原因 1

​	公司有一个框架，用 `java` 写 `SQL`，维护表结构。

​	虽然**高度封装 API **, 但依旧非常麻烦，在某些 Table 设计不合理下，你要写 50-60行 java，来维护 1 Table（Create Table + Create Index + Add Constraint + ...）

​	这很辛苦，比我写 SQL 慢太多了（慢1000%+) 。

> 1、解决 **entity -> SQL** 问题

### 原因 2

​	同时，随着时代发展，我们的 Table 逐渐去除 FK（Foreign Key），当 Table 命名不规范的时候，你根本不知道一些==字段的关联关系==。

> 2、从 **Java** 层面，可视化 **Table关系**，==辅助决策== 。



---------

# 补充

​	目前代码中，很多注释，很乱。一定版本迭代后，会重新梳理。

​	目前注释只是为了记录详细一点，好让我思路不中断。

​	希望大家能提出很 cool 的建议~

