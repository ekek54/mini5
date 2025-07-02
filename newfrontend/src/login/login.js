import React, { useState } from 'react';

const Login = () => {
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log('로그인 시도:', { email, password });
  };

  return (
    <div
      style={{
        display: 'flex',
        justifyContent: 'center',    // 수평 가운데 정렬
        alignItems: 'center',        // 수직 가운데 정렬
        height: '100vh',             // 전체 높이 채우기
        backgroundColor: '#fff',
      }}
    >
      <form
        onSubmit={handleSubmit}
        style={{
          display: 'flex',
          flexDirection: 'column',
          width: '300px',
          gap: '10px',
          padding: '30px',
          borderRadius: '8px',
          boxShadow: '0 0 10px rgba(0,0,0,0.1)',
          backgroundColor: '#f9f9f9',
        }}
      >
        <h2 style={{ textAlign: 'center' }}>로그인</h2>
        <input
          type="email"
          placeholder="이메일"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          required
        />
        <input
          type="password"
          placeholder="비밀번호"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
          required
        />
        <button type="submit">로그인</button>
      </form>
    </div>
  );
};

export default Login;

