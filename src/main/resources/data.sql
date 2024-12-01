-- Insertar roles básicos
INSERT INTO public.roles(id, name)
VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN'), (3, 'ROLE_WORKER')
ON CONFLICT (id) DO NOTHING;

-- Insertar proyecto por defecto
INSERT INTO public.projects(id, project_name, description, price)
VALUES (1, 'Default Project', 'Default project description', 0.0)
ON CONFLICT (id) DO NOTHING;

-- Insertar cliente admin
INSERT INTO public.clients(client_id, client_name, email, password)
VALUES (1, 'admin', 'admin@admin.com', '$2a$10$VReY3QH7imZ29.gAVgiy3.nPWVAMTE6o5t0YaZ32xB05lohtygByO')
ON CONFLICT (client_id) DO NOTHING;

-- Asignar rol admin al cliente admin
INSERT INTO public.client_roles(client_id, role_id)
VALUES (1, 2)
ON CONFLICT (client_id, role_id) DO NOTHING;

-- Asignar proyecto por defecto al cliente admin
INSERT INTO public.client_projects(client_id, project_id)
VALUES (1, 1)
ON CONFLICT (client_id, project_id) DO NOTHING;

-- Insertar usuario de prueba
INSERT INTO public.clients(client_id, client_name, email, password)
VALUES (2, 'usuario', 'usuario@usuario.com', '$2a$10$VReY3QH7imZ29.gAVgiy3.nPWVAMTE6o5t0YaZ32xB05lohtygByO')
ON CONFLICT (client_id) DO NOTHING;

-- Asignar rol user al usuario de prueba
INSERT INTO public.client_roles(client_id, role_id)
VALUES (2, 1)
ON CONFLICT (client_id, role_id) DO NOTHING;

-- Asignar proyecto por defecto al usuario de prueba
INSERT INTO public.client_projects(client_id, project_id)
VALUES (2, 1)
ON CONFLICT (client_id, project_id) DO NOTHING;

INSERT INTO projects (project_name, description, price) VALUES
('Project Alpha', 'An innovative AI project to enhance productivity.', 1500.50),
('Project Beta', 'A web-based application for project management.', 2500.00),
('Project Gamma', 'An advanced e-commerce platform.', 3000.75),
('Project Delta', 'A custom CRM solution for businesses.', 2000.00),
('Project Epsilon', 'A cutting-edge data analytics tool.', 3500.25);
