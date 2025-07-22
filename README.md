## 目录

```bash
# 前端
所有文件均在/frontend下

# 后端
所有文件均在/backend下

# 环境
redis与Navicat在所属独立文件夹下

# Github仓库
.gitignore控制的是 整个 Git 仓库的忽略规则，不部署子模块的话必须放在根目录下

# README.md
即本文件 作为项目说明会在Github的repositories页显示
```

## 首次配置

```bash
# 克隆
接受邀请后启动cmd
在你想要储存项目的目录下输入：

git clone https://github.com/Crush6x9/Web-design.git

这条命令会在当前目录下自动新建一个叫 Web-design 的文件夹，并把整个项目拉下来

```

## 更新！这一步非常重要，避免冲突！

```bash
# 最重要的一点：所有 git 命令必须在 Web-design 项目根目录下执行（就是 frontend 和 backend 的父目录）

# 每次开始写代码之前
在cmd项目根目录下输入：

git pull origin main

拉取最新代码，确保你是基于最新版本修改的

# 每次更新完代码之后
启动cmd
在项目根目录下依次运行以下三条命令：

git add .
git commit -m "你的提交说明"
git push origin main

第一条命令add .只会上传所有你修改过的文件，所以不必担心缓存问题
```

## 

```bash
# 后续注解接着往下写
```
##前端开发指南 - Network Graveyard 项目 (Vue.js)
这是使用 Vue.js 开发 Network Graveyard 前端项目的指南，后端基于 Spring Boot 提供了 RESTful API。以下步骤将帮助你设置环境、连接后端并开始开发。

##技术栈
框架: Vue.js 3.x
编辑器: Visual Studio Code (VSCode)
构建工具: Node.js, npm
HTTP 客户端: Axios
后端地址: http://localhost:8080/api (默认，后端端口可配置)

##环境搭建
 #1. 安装 Node.js 和 npm
下载并安装 Node.js (推荐 LTS 版本)。
验证安装：
node -v
npm -v
确保版本号显示（例如 v18.x.x 和 8.x.x）。
#2. 设置 VSCode
下载并安装 VSCode。
安装 Vue 相关扩展：
Vetur 或 Vue 3 Snippets（代码补全）
ESLint（代码检查）
打开终端（Terminal > New Terminal）。
#3. 创建 Vue 项目
使用 Vue CLI 或 Vite 创建项目：
Vue CLI:
npm install -g @vue/cli
vue create network-graveyard-frontend
选择默认配置或手动添加 Vue 3、Router、Vuex/Pinia。
Vite (推荐):
npm create vue@latest
cd network-graveyard-frontend
npm install
选择 Vue 3、TypeScript (可选)、Pinia (状态管理)、ESLint。
启动开发服务器：
npm run dev
浏览器打开 http://localhost:5173（Vite 默认端口）。
##连接后端
#1. 安装 Axios
在项目中安装 Axios：
npm install axios
#2. 配置 API 代理
避免 CORS 问题，配置代理（Vite 示例）： 在 vite.config.js 中添加：
javascript：


import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';

export default defineConfig({
  plugins: [vue()],
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/api/, '')
      }
    }
  }
});
重启开发服务器。
#3. 示例代码
创建服务文件 (src/services/api.js)：
javascript：



import axios from 'axios';

const api = axios.create({
  baseURL: '/api',
  headers: {
    'Content-Type': 'application/json'
  }
});

// 添加 token (登录后设置)
api.interceptors.request.use(config => {
  const token = localStorage.getItem('token');
  if (token) {
    config.headers.Authorization = `Bearer ${token}`;
  }
  return config;
});

export default api;
示例组件 (src/views/NetworkList.vue)：
vue：

<template>
  <div>
    <h1>Network List</h1>
    <ul>
      <li v-for="network in networks" :key="network.id">
        {{ network.name }} - {{ network.status }}
      </li>
    </ul>
    <button @click="fetchNetworks">Refresh</button>
  </div>
</template>

<script>
import api from '../services/api';

export default {
  data() {
    return {
      networks: []
    };
  },
  methods: {
    async fetchNetworks() {
      try {
        const response = await api.get('/networks', {
          params: { status: 'active', page: 1, size: 10 }
        });
        this.networks = response.data.data;
      } catch (error) {
        console.error('Error fetching networks:', error);
      }
    }
  },
  mounted() {
    this.fetchNetworks();
  }
};
</script>

<style scoped>
ul { list-style-type: none; padding: 0; }
li { margin: 10px 0; }
</style>
#4. 登录与认证
处理登录 API (/api/auth/login)：
javascript：

async function login(username, password) {
  const response = await api.post('/auth/login', { username, password });
  localStorage.setItem('token', response.data.token);
  return response.data;
}
保护路由（使用 Vue Router + 导航守卫）：
javascript：

import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: '/login', component: LoginView },
    { path: '/networks', component: NetworkList, meta: { requiresAuth: true } }
  ]
});

router.beforeEach((to, from, next) => {
  if (to.meta.requiresAuth && !localStorage.getItem('token')) {
    next('/login');
  } else {
    next();
  }
});

export default router;
##开发注意事项
CORS: 后端已支持 http://localhost:3000 或 5173，如需其他端口，请联系后端开发调整。
# 错误处理: API 错误返回 error 字段，需在前端显示用户友好的提示。
实时数据: 使用 WebSocket (/ws/network-updates)，可集成 vue-socket.io：
npm install vue-socket.io
配置示例见官方文档。
环境变量: 在 .env 文件中定义：
text：

VITE_API_BASE_URL=/api
# 运行与测试
开发：npm run dev
构建：npm run build (生成 dist 目录)
测试：使用 Postman 测试 API，或在浏览器开发者工具查看网络请求。
联系方式
如有疑问，请联系后端开发人员（@Gazera-y）或提交 GitHub Issue。
