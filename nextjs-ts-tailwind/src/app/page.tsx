export default function HomePage() {
	return (
		<main className="flex min-h-screen flex-col items-center justify-center p-6">
			<div className="mx-auto max-w-2xl text-center">
				<h1 className="text-4xl font-bold tracking-tight sm:text-6xl">Next.js + TypeScript + Tailwind</h1>
				<p className="mt-6 text-lg leading-8 text-gray-600">
					Starter template is working. Edit <code className="rounded bg-gray-100 px-1 py-0.5">src/app/page.tsx</code> to get started.
				</p>
				<div className="mt-10 flex items-center justify-center gap-x-6">
					<a
						href="https://nextjs.org/docs"
						className="rounded-md bg-black px-3.5 py-2.5 text-sm font-semibold text-white shadow-sm hover:bg-gray-800 focus-visible:outline focus-visible:outline-2 focus-visible:outline-offset-2 focus-visible:outline-black"
					>
						Next.js Docs
					</a>
					<a href="https://tailwindcss.com/docs" className="text-sm font-semibold leading-6">
						Tailwind Docs <span aria-hidden="true">→</span>
					</a>
				</div>
			</div>
		</main>
	);
}