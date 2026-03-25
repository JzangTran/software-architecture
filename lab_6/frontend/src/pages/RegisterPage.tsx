import { useState, type ChangeEvent, type FormEvent } from "react";
import { Link, useNavigate } from "react-router-dom";
import { register } from "../services/authService";
import type { RegisterRequest } from "../types/auth";
import "./AuthPage.css";

export default function RegisterPage() {
    const navigate = useNavigate();

    const [form, setForm] = useState<RegisterRequest>({
        name: "",
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
            await register(form);
            alert("Register success");
            navigate("/login");
        } catch (err: any) {
            alert(err.message);
        }
    };

    return (
        <div className="auth-page">
            <div className="auth-card">
                <h2 className="auth-title">Create account</h2>
                <p className="auth-subtitle">Tạo tài khoản mới để bắt đầu</p>

                <form className="auth-form" onSubmit={handleSubmit}>
                    <div className="auth-group">
                        <label className="auth-label" htmlFor="name">
                            Name
                        </label>
                        <input
                            id="name"
                            className="auth-input"
                            name="name"
                            placeholder="Enter your name"
                            value={form.name}
                            onChange={handleChange}
                        />
                    </div>

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
                        Register
                    </button>
                </form>

                <div className="auth-footer">
                    Đã có tài khoản?{" "}
                    <Link className="auth-link" to="/login">
                        Login
                    </Link>
                </div>
            </div>
        </div>
    );
}