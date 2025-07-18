<template>
  <div class="git">
    <img src="/git.png" style="width: 100%;">
    <a href="https://github.com/Crush6x9/Web-design" target="_blank" class="git-button">
      加入我们的项目
    </a>
  </div>
</template>

<script>
export default {
  name: 'GithubIndex'
}
</script>

<style scoped>

.git {
  margin-left: 0%;
  margin-top: 0%;
  width: 100%;
  position: relative; 
}

.git-button {
  position: absolute;
  top: 65%; 
  left: 50%; 
  transform: translate(-50%, -50%); 
  padding: 15px 40px; 
  background-color: #4caf4f; 
  color: white; 
  text-decoration: none; 
  border-radius: 10px; 
  transition: background-color 0.3s ease; 
  font-size: 16px;
  font-weight: 600;
  cursor: pointer;
}

.git-button:hover {
  background-color: #459a49; 
}

@media (max-width: 768px) {
  .git-button {
    font-size: 14px;
    padding: 8px 16px;
  }
}
</style>
