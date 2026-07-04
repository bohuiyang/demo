# M0 Git 冲突场景

## 场景说明

你按组长要求从 main 拉 `feature/user-nickname-fix` 分支改 bug。
在你改代码的同时，同事张三（zhangsan）也改了一个 bug 并先合并到了 main。

你的改动和张三的改动**改了同一个文件的同一行** → 合并时产生冲突。

---

## 冲突详情

### 文件：`UserServiceImpl.java` 的 `listUsers()` 方法

### 张三推送到 main 的版本（`zhangsan-bugfix.java`）
张三修了一个 NPE bug：当用户 nickname 为 null 时，`setNickname(null)` 会导致前端显示 "null"。
他的改法：nickname 为 null 时设为空字符串 ""。

```java
// 张三的版本（main 分支上）
vo.setNickname(user.getNickname() != null ? user.getNickname() : "");
```

### 你的版本（`feature/user-nickname-fix` 分支）
你修了"昵称显示 bug"，你的改法：nickname 为 null 时显示 "未知用户"。

```java
// 你的版本（feature/user-nickname-fix 分支）
vo.setNickname(user.getNickname() != null ? user.getNickname() : "未知用户");
```

### 张三推到 main 的另一个改动（`zhangsan-phonefix.java`）
张三还加了一个 phone 字段的显示，同时改了同一行的 vo.setNickname 上方代码。
这样当你的分支 merge main 时，conflict 区域更大，更接近真实场景。

---

## 怎么触发冲突（AI 教练操作步骤）

### 方式 1：手动操作（推荐，简单可控）

```bash
# === 以下由 AI 教练在另一个终端操作 ===

# 1. 在项目目录，确认在 main 分支
git checkout main

# 2. 用 zhangsan-bugfix.java 的内容替换 UserServiceImpl.java
cp conflict-scenarios/zhangsan-bugfix.java \
   src/main/java/com/example/demo/service/impl/UserServiceImpl.java

# 3. 提交并推送
git add .
git commit -m "fix: 张三 — 用户昵称为 null 时返回空字符串，避免前端显示 null"
# （本地演示可以不用 push，直接让学员 git pull 或 git merge main）
```

### 方式 2：用脚本自动创建（适合课堂演示）

```bash
bash conflict-scenarios/setup-conflict.sh
```

---

## 冲突文件对照

| 文件 | 说明 |
|------|------|
| `zhangsan-bugfix.java` | 张三推送到 main 的版本（完整文件） |
| `your-change.java` | 学员要改成什么样子（不是完整文件，是改动说明） |
| `setup-conflict.sh` | 自动创建冲突的脚本 |
