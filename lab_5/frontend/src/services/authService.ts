import type { RegisterRequest, LoginRequest, TokenResponse } from "../types/auth";


const API_REGISTER = "http://localhost:8386/api/v1/register";
const API_LOGIN = "http://localhost:8082/auth/login";

export async function register(data: RegisterRequest): Promise<void> {
    const res = await fetch(API_REGISTER, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    });

    if (!res.ok) {
        throw new Error("Register failed");
    }
}

export async function login(data: LoginRequest): Promise<TokenResponse> {
    const res = await fetch(API_LOGIN, {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify(data),
    });

    if (!res.ok) {
        throw new Error("Login failed");
    }

    return res.json();
}