# Forward Engineer 正向工程

**current-version = v0.0.1**

当前版本 = v0.0.1

> @author: SolarisNeko 
>
> @startDate: Saturday，03/07/2021

## preface 前言

​	Author still learning, is a Rookie.

​	Give me some issue make me think it is cool .

> 作者是一个菜鸟，还在学习。
>
> 开源，希望大家给我一些很 cool 的建议~

## Origin Intention 初衷

### 原因 1

​	公司有一个框架，用 `java` 写 `SQL`，维护表结构。

​	虽然**高度封装 API **, 但依旧非常麻烦，在某些 Table 设计不合理下，你要写 50-60行 java，来维护 1 Table（Create Table + Create Index + Add Constraint + ...）

​	这很辛苦，比我写 SQL 慢太多了（慢1000%+) 。

> 1、解决 **entity -> SQL** 问题

### 原因 2

​	同时，随着时代发展，我们的 Table 逐渐去除 FK（Foreign Key），当 Table 命名不规范的时候，你根本不知道一些==字段的关联关系==。

> 2、从 Java 层面，可视化 **Table关系**，==辅助决策== 。



# 补充

​	目前代码中，很多注释，很乱，这些后续确定没问题后，都会重新编写。

​	目前注释只是为了记录详细一点。好让我思路不中断。

​	因为每天我都要处理很多事情，很容易 Context Change(上下文切换) 。

