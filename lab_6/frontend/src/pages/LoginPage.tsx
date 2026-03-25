import { useState, type ChangeEvent, type FormEvent } from "react";
import { Link, useNavigate } from "react-router-dom";
import { login } from "../services/authService";
import { type LoginRequest } from "../types/auth";
import "./AuthPage.css";

export default function LoginPage() {
    const navigate = useNavigate();

    const [form, setForm] = useState<LoginRequest>({
        email: "",
        password: "",
    });

    const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
        setForm({
            ...form,
            [e.target.name]: e.target.value,
        });
    };

    const handleSubmit = async (e: FormEvent) => {
        e.preventDefault();

        try {
            const res = await login(form);

            localStorage.setItem("accessToken", res.accessToken);
            localStorage.setItem("refreshToken", res.refreshToken);

            alert("Login success");
            navigate("/"); // tạm thời, bên dưới mình sẽ sửa route home
        } catch (err: any) {
            alert(err.message);
        }
    };

    return (
        <div className="auth-page">
            <div className="auth-card">
                <h2 className="auth-title">Welcome back</h2>
                <p className="auth-subtitle">Đăng nhập để tiếp tục</p>

                <form className="auth-form" onSubmit={handleSubmit}>
                    <div className="auth-group">
                        <label className="auth-label" htmlFor="email">
                            Email
                        </label>
                        <input
                            id="email"
                            className="auth-input"
                            name="email"
                            type="email"
                            placeholder="Enter your email"
                            value={form.email}
                            onChange={handleChange}
                        />
                    </div>

                    <div className="auth-group">
                        <label className="auth-label" htmlFor="password">
                            Password
                        </label>
                        <input
                            id="password"
                            className="auth-input"
                            name="password"
                            type="password"
                            placeholder="Enter your password"
                            value={form.password}
                            onChange={handleChange}
                        />
                    </div>

                    <button className="auth-button" type="submit">
                        Login
                    </button>
                </form>

                <div className="auth-footer">
                    Chưa có tài khoản?{" "}
                    <Link className="auth-link" to="/register">
                        Register
                    </Link>
                </div>
            </div>
        </div>
    );
}